package com.joker.module.wechat.api.result;

import java.io.Serializable;

/**
 * Created by zhangjian on 2016/11/21.
 */
public class BaseResult implements Serializable{

    private Integer errcode;
    private String errmsg;

    public BaseResult(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public BaseResult() {
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }


    public boolean isSuccess(){
        return errcode != null && errcode == 0 && errmsg != null && "ok".equalsIgnoreCase(errmsg);
    }

}
