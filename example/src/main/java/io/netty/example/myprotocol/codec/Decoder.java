package io.netty.example.myprotocol.codec;

/**
 * @Author panligang3
 * @create 2020/11/29 11:16 上午
 */
public interface Decoder {

    public Object decoder(byte[] bytes,Class cls);
}
