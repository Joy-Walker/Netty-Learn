package io.netty.example.splicing.lengthField;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author panligang3
 * @create 2020/11/23 2:14 PM
 */
public class StringDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        System.out.println("StringDecoder 被调用");
        out.add(msg.toString(CharsetUtil.UTF_8));
    }
}
