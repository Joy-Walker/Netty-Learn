package io.netty.example.pipeline.exception;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author panligang3
 * @create 2020/11/16 2:02 PM
 */
public class InHanderB extends ChannelInboundHandlerAdapter {


    @Override
    public  void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        throw new RuntimeException("hello world");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Inbound B exceptionCaught");
        ctx.fireExceptionCaught(cause);
//        ctx.pipeline().fireExceptionCaught(cause);
    }
}
