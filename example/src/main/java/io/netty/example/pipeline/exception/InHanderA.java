package io.netty.example.pipeline.exception;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author panligang3
 * @create 2020/11/16 11:48 AM
 */
public class InHanderA extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Inbound A exceptionCaught");
        ctx.fireExceptionCaught(cause);
    }
}
