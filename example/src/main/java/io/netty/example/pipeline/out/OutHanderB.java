package io.netty.example.pipeline.out;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @Author panligang3
 * @create 2020/11/16 2:02 PM
 */
public class OutHanderB extends ChannelOutboundHandlerAdapter {


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        String s = msg.toString();
        System.out.println("B: " + s);
        ctx.write(msg);
    }
}
