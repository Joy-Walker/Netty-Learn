package io.netty.example.codec.fastjson;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Author panligang3
 * @create 2020/11/27 3:56 下午
 */
public class FastJsonDecoder extends ByteToMessageDecoder {

    private Class clazz;

    public FastJsonDecoder( Class clazz) {
        this.clazz = clazz;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int length = msg.readableBytes();
        byte[] arr = new byte[length];
        msg.readBytes(arr,0,length);
        out.add(JSON.parseObject(arr,clazz));
    }
}
