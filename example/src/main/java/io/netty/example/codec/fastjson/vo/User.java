package io.netty.example.codec.fastjson.vo;

import java.io.Serializable;

/**
 * @Author panligang3
 * @create 2020/11/27 4:28 下午
 */
public class User implements Serializable {
    private String name = "aaa";
    private String age = "10";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
