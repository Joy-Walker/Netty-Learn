package io.netty.example.myprotocol.codec;

/**
 * @Author panligang3
 * @create 2020/11/29 11:15 上午
 */
public interface Encoder {

    public byte[] encoder(Object obj);
}
