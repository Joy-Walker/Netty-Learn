package io.netty.example.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;


/**
 * @Author panligang3
 * @create 2020/12/4 4:34 下午
 */
public class ServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String message = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println("收到响应:" + message);
        ctx.writeAndFlush(
                new DatagramPacket(Unpooled.copiedBuffer("AAAA", CharsetUtil.UTF_8),msg.sender()));
    }
}
