package io.netty.example.myprotocol.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.example.myprotocol.util.MessageBuilder;
import io.netty.example.myprotocol.vo.Message;
import io.netty.example.myprotocol.vo.MessageType;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.MessageUtils;

/**
 * @Author panligang3
 * @create 2020/11/29 11:23 上午
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    private String name;

    public HeartBeatHandler(String name) {
        this.name = name;
    }

    private static  Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        if(message.getMessageHeader().getMessageType() == MessageType.HEARTBEAT){
           logger.info("[{}] 处理心跳报文[{}]",name,message.getContent());
            MessageBuilder.buildMessage(MessageType.HEARTBEAT,"心跳报文");
            ReferenceCountUtil.release(msg);
        }else{
            ctx.fireChannelRead(msg);
        }
    }
}
