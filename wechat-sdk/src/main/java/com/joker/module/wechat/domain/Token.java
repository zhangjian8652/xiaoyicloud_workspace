package com.joker.module.wechat.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zhangjian on 2016/10/28.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Token {

    private String accessToken;
    private int expiresIn;


    public Token(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public Token() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "Token{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
