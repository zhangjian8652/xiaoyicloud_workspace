package com.joker.module.wechat.error;

import java.io.Serializable;

/**
 * Created by zhangjian on 2016/11/21.
 */
public class BaseError implements Serializable{

    private String errcode;
    private String errmsg;

    public BaseError(String errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public BaseError() {
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
