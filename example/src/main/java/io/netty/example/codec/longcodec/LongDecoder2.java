package io.netty.example.codec.longcodec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @Author panligang3
 * @create 2020/11/25 10:36 上午
 */
public class LongDecoder2 extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if(msg.readableBytes() >= 8){
           out.add( msg.readLong());
        }
    }
}
