package io.netty.example.pipeline.exception;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author panligang3
 * @create 2020/11/16 2:03 PM
 */
public class InHandlerC extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Inbound C exceptionCaught");
        ctx.fireExceptionCaught(cause);
    }
}
