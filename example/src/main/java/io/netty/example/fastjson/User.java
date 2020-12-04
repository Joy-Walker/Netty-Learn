package io.netty.example.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author panligang3
 * @create 2020/11/30 10:53 上午
 */
public class User implements Serializable {

    @JSONField(name="AGE")
    private Integer age;

    private String name;

    private Date birthday;

    private List<User> frinds;

    private Map<String,Object> attach;

    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<User> getFrinds() {
        return frinds;
    }

    public void setFrinds(List<User> frinds) {
        this.frinds = frinds;
    }

    public Map<String, Object> getAttach() {
        return attach;
    }

    public void setAttach(Map<String, Object> attach) {
        this.attach = attach;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", frinds=" + frinds +
                ", attach=" + attach +
                '}';
    }
}
