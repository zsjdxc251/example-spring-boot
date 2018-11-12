package com.lesson.boot.mvc.converter.entity;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
public class UserDTO {

    private String username;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
