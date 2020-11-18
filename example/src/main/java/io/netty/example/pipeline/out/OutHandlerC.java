package io.netty.example.pipeline.out;

import io.netty.channel.*;

import java.net.SocketAddress;

/**
 * @Author panligang3
 * @create 2020/11/16 2:03 PM
 */
public class OutHandlerC extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        String s = msg.toString();
        System.out.println("C: " + s);
        ctx.write(msg);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().write("hello world");
    }

}
