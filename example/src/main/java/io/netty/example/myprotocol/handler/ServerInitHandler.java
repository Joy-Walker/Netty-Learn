package io.netty.example.myprotocol.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.myprotocol.codec.FastJSONDecoder;
import io.netty.example.myprotocol.codec.FastJSONEncoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @Author panligang3
 * @create 2020/11/29 11:32 上午
 */
public class ServerInitHandler extends ChannelInitializer<NioSocketChannel> {
    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {

        ch.pipeline().addLast(new LengthFieldPrepender(2));
        ch.pipeline().addLast(new MessageEncoder(new FastJSONEncoder()));
        // 处理TCP粘包问题
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024,0,2,0,2));
        // 报文解码
        ch.pipeline().addLast(new MessageDecoder(new FastJSONDecoder()));
        // 处理心跳报文
        ch.pipeline().addLast(new HeartBeatHandler("server"));
        // 处理登录报文
        ch.pipeline().addLast(new LoginHander("server"));
        ch.pipeline().addLast(new BuisHandler("server"));
        ch.pipeline().addLast(new ExceptionHandler());

    }
}
