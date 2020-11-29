package io.netty.example.myprotocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.codec.fastjson.EchoClientHandler;
import io.netty.example.codec.fastjson.FastJsonEncoder;
import io.netty.example.myprotocol.handler.ClientInitHandler;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @Author panligang3
 * @create 2020/11/29 1:39 下午
 */
public class NettyClient {
    public static void main(String[] args) throws Exception {


        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new ClientInitHandler());
                        }
                    });

            // Start the client.
            ChannelFuture f = b.connect("127.0.0.1", 8007).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }
    }
}
