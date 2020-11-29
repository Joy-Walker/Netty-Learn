package io.netty.example.myprotocol.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.example.myprotocol.util.MessageBuilder;
import io.netty.example.myprotocol.vo.Message;
import io.netty.example.myprotocol.vo.MessageType;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author panligang3
 * @create 2020/11/29 1:29 下午
 */

public class BuisHandler extends ChannelInboundHandlerAdapter {
    private String name;


    private static final Logger LOGGER = LoggerFactory.getLogger(BuisHandler.class);

    public BuisHandler(String name) {
        this.name = name;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        Message message = (Message) msg;
        if (message.getMessageHeader().getMessageType() == MessageType.SERVICE_) {
            LOGGER.info("[{}] 处理业务报文[{}]", name, message.getContent());
            MessageBuilder.buildMessage(MessageType.LOGIN, "响应业务报文");
            ReferenceCountUtil.release(msg);
        } else {
            ctx.fireChannelRead(msg);

        }
    }
}
