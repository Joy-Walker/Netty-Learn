package io.netty.example.myprotocol.codec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author panligang3
 * @create 2020/11/29 11:17 上午
 */
public class FastJSONDecoder implements Decoder{

    @Override
    public Object decoder(byte[] bytes, Class cls) {
        return JSON.parseObject(bytes,cls);
    }
}
