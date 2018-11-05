package com.chen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    //可以在转换时改变属性的名字
    @JsonProperty("username")
    private String name;

    // 返回 json 字符串时忽略该属性
    @JsonIgnore
    private int age;

    //将浏览器发送过来的日期格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // json字符串：将服务器发送出去的日期格式化,
    @JsonFormat(pattern = "yyyy-MM-dd mm:ss",timezone = "GMT+8")
    private Date birthday;

    public User() {
    }

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
