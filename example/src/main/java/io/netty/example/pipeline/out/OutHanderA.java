package io.netty.example.pipeline.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @Author panligang3
 * @create 2020/11/16 11:48 AM
 */
public class OutHanderA extends ChannelOutboundHandlerAdapter {


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        String s = msg.toString();
        System.out.println("A: " + s);
        ctx.write(msg);
    }
}
