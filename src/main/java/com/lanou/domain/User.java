package com.lanou.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by dllo on 17/11/10.
 */
public class User {
    @NotBlank(message = "用户名不能为空")
    public String username;
    @NotBlank(message = "密码不能为空")
    public String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
