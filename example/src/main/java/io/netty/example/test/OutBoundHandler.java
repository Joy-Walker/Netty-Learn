package io.netty.example.test;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketAddress;

/**
 * @Author panligang3
 * @create 2020/11/29 9:28 下午
 */
public class OutBoundHandler  extends ChannelOutboundHandlerAdapter {

    private static Logger LOGGER = LoggerFactory.getLogger(OutBoundHandler.class);

    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        LOGGER.info("bind");
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        LOGGER.info("connect");
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
       LOGGER.info("disconnect");
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        LOGGER.info("close");

    }

    @Override
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        LOGGER.info("deregister");

    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("read");
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        LOGGER.info("write");

    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("flush");

    }
}
