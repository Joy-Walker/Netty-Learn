package io.netty.example.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @Author panligang3
 * @create 2020/12/4 4:27 下午
 */
public class EchoServer {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();

        EventLoopGroup work = new NioEventLoopGroup();

        bootstrap.group(work).channel(NioDatagramChannel.class)
                .handler(new ServerHandler());
        try {
            ChannelFuture future = bootstrap.bind(8888).sync();
            System.out.println("服务器启动成功");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
