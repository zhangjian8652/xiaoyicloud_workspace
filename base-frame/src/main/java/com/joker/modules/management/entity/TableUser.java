package com.joker.modules.management.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/12/15
 */
public class TableUser {
    private String id;
    private String no;
    private String username;
    private String sex;
    private String email;
    private String mobile;

    public TableUser(String id, String no, String username, String sex, String email, String mobile) {
        this.id = id;
        this.no = no;
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public static List<TableUser> tansferUsersToTableUsers(List<User> users) {

        List<TableUser> tableUsers = new ArrayList<>();

        for (int i = 0; i < users.size() ; i++) {
            User user =  users.get(i);
            TableUser tableUser = new TableUser(user.getId() + "",user.getIndex() + "",user.getUsername(),user.getSex().toString(),user.getEmail(),user.getMobile());
            tableUsers.add(tableUser);
        }
        return  tableUsers;
    }

    @Override
    public String toString() {
        return "TableUser{" +
                "id='" + id + '\'' +
                ", no='" + no + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
