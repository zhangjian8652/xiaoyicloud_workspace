package com.joker.module.wechat.domain;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class Logo{

    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "url='" + url + '\'' +
                '}';
    }
}