package io.netty.example.myprotocol.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.myprotocol.codec.Decoder;
import io.netty.example.myprotocol.vo.Message;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @Author panligang3
 * @create 2020/11/29 1:18 下午
 */
public class MessageDecoder extends ByteToMessageDecoder {
    private Decoder decoder;


    public MessageDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
       int length = msg.readableBytes();
       byte[] bytes = new byte[length];
       msg.readBytes(bytes,msg.readerIndex(),length);
       out.add(decoder.decoder(bytes, Message.class));
     }
}
