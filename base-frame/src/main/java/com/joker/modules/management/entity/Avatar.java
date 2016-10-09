package com.joker.modules.management.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangjian
 * @Date 2015/11/21
 */
public class Avatar implements Serializable {

    private int id;
    private String name;
    private String path;
    private Date createOn;
    private Date updateOn;

    public Avatar(String name, String path, Date createOn, Date updateOn) {
        this.name = name;
        this.path = path;
        this.createOn = createOn;
        this.updateOn = updateOn;
    }

    public Avatar(Integer id, String name, String path, Date createOn, Date updateOn) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.createOn = createOn;
        this.updateOn = updateOn;
    }

    public Avatar(String name, String path) {
        this.name = name;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        return "Avatar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", createOn=" + createOn +
                ", updateOn=" + updateOn +
                '}';
    }
}
