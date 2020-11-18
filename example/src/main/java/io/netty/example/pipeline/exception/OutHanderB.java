package io.netty.example.pipeline.exception;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @Author panligang3
 * @create 2020/11/16 2:02 PM
 */
public class OutHanderB extends ChannelOutboundHandlerAdapter {


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Outbound B exceptionCaught");
        ctx.fireExceptionCaught(cause);
    }
}
