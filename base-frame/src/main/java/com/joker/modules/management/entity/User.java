package com.joker.modules.management.entity;


import com.joker.modules.management.enums.Sex;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangjian
 * Date: 2015/9/1
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    private int id;

    @NotNull
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String mobile;
    private Sex sex;
    @NotNull
    private String password;
    private Avatar avatar;
    private int index;
    private Date createOn;
    private Date updateOn;

    private List<Role> roles;
    private Organization organization;

    public User() {
    }

    public User(String username, String email, String mobile, Sex sex, String password, Avatar avatar, int id) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.sex = sex;
        this.password = password;
        this.avatar = avatar;
        this.id = id;
    }

    public User(String username, String email, String mobile, Sex sex, String password, Avatar avatar) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.sex = sex;
        this.password = password;
        this.avatar = avatar;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", avatar=" + avatar +
                ", createOn=" + createOn +
                ", updateOn=" + updateOn +
                '}';
    }
}
