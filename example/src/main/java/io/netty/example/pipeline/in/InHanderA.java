package io.netty.example.pipeline.in;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author panligang3
 * @create 2020/11/16 11:48 AM
 */
public class InHanderA extends ChannelInboundHandlerAdapter {

    @Override
    public  void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String s = msg.toString();

        System.out.println("A " + s);

        ctx.fireChannelRead(msg);

    }
}
