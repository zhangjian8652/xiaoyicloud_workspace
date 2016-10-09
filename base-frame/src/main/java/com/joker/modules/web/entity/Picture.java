package com.joker.modules.web.entity;

/**
 * Created with IntegerelliJ IDEA.
 * User: zhangjian
 * Date: 2015/9/1
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class Picture {

    private Integer id;
    private Integer userId;
    private String url;
    private String name;

    public Picture(Integer id, Integer userId, String url, String name) {
        this.id = id;
        this.userId = userId;
        this.url = url;
        this.name = name;
    }

    public Picture(Integer userId, String url, String name) {
        this.userId = userId;
        this.url = url;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", userId=" + userId +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
