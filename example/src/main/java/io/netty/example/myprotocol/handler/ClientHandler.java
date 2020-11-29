package io.netty.example.myprotocol.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.example.myprotocol.util.MessageBuilder;
import io.netty.example.myprotocol.vo.Message;
import io.netty.example.myprotocol.vo.MessageType;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author panligang3
 * @create 2020/11/29 1:31 下午
 */
public class ClientHandler  extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);

    private String name;

    public ClientHandler(String name) {
        this.name = name;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;

        switch (message.getMessageHeader().getMessageType()){
            case LOGIN:
                LOGGER.info("[{}] 处理登录报文[{}]",name,message.getContent());
                MessageBuilder.buildMessage(MessageType.LOGIN,"响应登录请求报文");
                ReferenceCountUtil.release(msg);
                break;
            case SERVICE_:
                LOGGER.info("[{}] 处理业务报文[{}]", name, message.getContent());
                MessageBuilder.buildMessage(MessageType.LOGIN, "响应业务报文");
                ReferenceCountUtil.release(msg);
                break;
            case HEARTBEAT:
                LOGGER.info("[{}] 处理心跳报文[{}]",name,message.getContent());
                MessageBuilder.buildMessage(MessageType.HEARTBEAT,"心跳报文");
                ReferenceCountUtil.release(msg);
                break;
            default:
                ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("channel success 发送消息...");
        ctx.writeAndFlush(MessageBuilder.buildMessage(MessageType.LOGIN,"登录请求"));
    }

}
