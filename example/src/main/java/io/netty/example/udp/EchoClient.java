package io.netty.example.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.example.myprotocol.handler.client.ClientHandler;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @Author panligang3
 * @create 2020/12/4 4:27 下午
 */
public class EchoClient {
    public static void main(String[] args) {
            Bootstrap bootstrap = new Bootstrap();

            EventLoopGroup work = new NioEventLoopGroup();

            bootstrap.group(work).channel(NioDatagramChannel.class)
                    .handler(new UDPClientHandler());
            try {
                ChannelFuture future = bootstrap.bind(7777).sync();
                //  启动成功就同步发送数据
                future.channel().writeAndFlush(
                        new DatagramPacket(Unpooled.copiedBuffer("DDDD", CharsetUtil.UTF_8),new InetSocketAddress("127.0.0.1",8888))
                ).sync();
                System.out.println("发送数据DDDD");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
