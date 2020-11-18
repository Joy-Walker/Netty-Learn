package io.netty.example.pipeline.exception;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;

/**
 * @Author panligang3
 * @create 2020/11/16 9:01 PM
 */
public class DealExceptionHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if(cause instanceof RuntimeException){
            System.out.println("发生了异常，关闭连接");
            ctx.channel().close();
        }
    }
}
