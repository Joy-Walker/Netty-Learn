package io.netty.example.myprotocol.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.myprotocol.codec.Encoder;
import io.netty.example.myprotocol.vo.Message;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author panligang3
 * @create 2020/11/29 1:24 下午
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {
    private Encoder encoder;

    public MessageEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        byte[] bytes = this.encoder.encoder(msg);
        out.writeBytes(bytes,0,bytes.length);
    }
}
