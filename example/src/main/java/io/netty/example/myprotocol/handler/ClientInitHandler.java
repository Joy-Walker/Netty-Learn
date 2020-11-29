package io.netty.example.myprotocol.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.myprotocol.codec.FastJSONDecoder;
import io.netty.example.myprotocol.codec.FastJSONEncoder;
import io.netty.example.myprotocol.util.MessageBuilder;
import io.netty.example.myprotocol.vo.MessageType;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author panligang3
 * @create 2020/11/29 11:31 上午
 */
public class ClientInitHandler extends ChannelInitializer<NioSocketChannel> {

    private static Logger logger = LoggerFactory.getLogger(ClientInitHandler.class);

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ch.pipeline().addLast(new LengthFieldPrepender(2));
        ch.pipeline().addLast(new MessageEncoder(new FastJSONEncoder()));
        // 处理TCP粘包问题
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024,0,2,0,2));
        // 报文解码
        ch.pipeline().addLast(new MessageDecoder(new FastJSONDecoder()));
        ch.pipeline().addLast(new ClientHandler("client"));
        ch.pipeline().addLast(new ExceptionHandler());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }


}
