package io.netty.example.codec.stringcodes;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author panligang3
 * @create 2020/11/23 2:14 PM
 *
 * 每次读到数据后，需要让读索引向前走不然就违背了netty的原则，会抛出异常
 */
public class StringDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
//        out.add(msg.toString(CharsetUtil.UTF_8));
//        msg.skipBytes(msg.readableBytes());

        int length = msg.readableBytes();

        if(length == 0){
            System.out.println("本次没有读取到任何数据。");
            return;
        }
        byte[] arr = new byte[length];
        msg.readBytes(arr,0,length);
        out.add(new String(arr,CharsetUtil.UTF_8));
    }
}
