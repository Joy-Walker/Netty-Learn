package io.netty.example.codec.longcodec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Author panligang3
 * @create 2020/11/24 4:33 下午
 */
public class LongDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("LongDecoder 被调用");
        if(in.readableBytes() >= 8){
            out.add(in.readLong());
        }
    }
}
