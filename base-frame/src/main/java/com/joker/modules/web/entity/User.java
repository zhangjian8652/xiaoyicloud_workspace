package com.joker.modules.web.entity;


import com.joker.modules.web.enums.Sex;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjian
 * Date: 2015/9/1
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String mobile;
    private Sex sex;
    private String password;
    private Picture picture;

    public User() {
    }

    public User(String name, String email, String mobile, Sex sex, String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.sex = sex;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", picture=" + picture +
                '}';
    }
}
