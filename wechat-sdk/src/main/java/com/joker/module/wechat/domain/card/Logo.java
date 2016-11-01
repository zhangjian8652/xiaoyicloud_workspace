package com.joker.module.wechat.domain.card;

/**
 * Created by zhangjian on 2016/10/31.
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
