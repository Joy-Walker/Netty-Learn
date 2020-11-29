package io.netty.example.myprotocol.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.example.myprotocol.util.MessageBuilder;
import io.netty.example.myprotocol.vo.Message;
import io.netty.example.myprotocol.vo.MessageType;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author panligang3
 * @create 2020/11/29 1:09 下午
 */
public class LoginHander extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginHander.class);

    private String name;

    public LoginHander(String name) {
        this.name = name;
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

            Message message = (Message) msg;
            if(message.getMessageHeader().getMessageType() == MessageType.LOGIN){
                LOGGER.info("[{}] 收到消息[{}]",name,message.getContent());
                Message message1 = MessageBuilder.buildMessage(MessageType.LOGIN, "登录成功...");
                ctx.channel().writeAndFlush(message1);
                ctx.executor().scheduleAtFixedRate(new HBTask(ctx),0,5000,TimeUnit.MILLISECONDS);
                ReferenceCountUtil.release(msg);
            }else{
                ctx.fireChannelRead(msg);
            }
    }
    class HBTask implements Runnable{
        private ChannelHandlerContext ctx;

        public HBTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            ctx.writeAndFlush(MessageBuilder.buildMessage(MessageType.HEARTBEAT,"心跳报文"));
        }
    }
}
