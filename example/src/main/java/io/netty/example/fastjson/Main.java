package io.netty.example.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @Author panligang3
 * @create 2020/11/30 10:55 上午
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(0);
        user.setName("aaa");
        user.setBirthday(new Date());
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);
        user.setFrinds(users);
        Map<String,Object> attach = new HashMap<>();
        attach.put("user",user);
        String s = JSON.toJSONString(user);
        System.out.println(s);
        User user1 = JSON.parseObject(s, User.class);
    }
}
