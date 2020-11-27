package io.netty.example.codec.fastjson;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.codec.fastjson.vo.User;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author panligang3
 * @create 2020/11/27 4:28 下午
 */
public class FastJsonEncoder extends MessageToByteEncoder<User> {

    @Override
    protected void encode(ChannelHandlerContext ctx, User user, ByteBuf out) throws Exception {
        byte[] bytes = JSON.toJSONBytes(user);
        out.writeBytes(bytes,0,bytes.length);
    }
}
