package io.netty.example.codec.stringcodes;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

/**
 *
 *
 * @Author panligang3
 * @create 2020/11/23 2:06 PM
 *
 * String的编码器
 */
public class StringEncoder extends MessageToByteEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        if(msg.length() == 0){
            return;
        }
        out.writeBytes(msg.getBytes(CharsetUtil.UTF_8));
    }
}
