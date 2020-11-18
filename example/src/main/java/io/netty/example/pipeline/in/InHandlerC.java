package io.netty.example.pipeline.in;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author panligang3
 * @create 2020/11/16 2:03 PM
 */
public class InHandlerC extends ChannelInboundHandlerAdapter {

    @Override
    public  void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String s = msg.toString();

        System.out.println("C " + s);

        ctx.fireChannelRead(msg);
    }
}
