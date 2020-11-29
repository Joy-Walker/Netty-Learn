package io.netty.example.myprotocol.codec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author panligang3
 * @create 2020/11/29 11:21 上午
 */
public class FastJSONEncoder implements Encoder {
    @Override
    public byte[] encoder(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
