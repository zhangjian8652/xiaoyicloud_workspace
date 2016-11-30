package com.joker.module.wechat.api.result;

/**
 * Created by zhangjian on 2016/11/29.
 */
public class MemberCardUpdateResult extends BaseResult {

    private int resultBonus;
    private int resultBalance;
    private int openid;

    public int getResultBonus() {
        return resultBonus;
    }

    public void setResultBonus(int resultBonus) {
        this.resultBonus = resultBonus;
    }

    public int getResultBalance() {
        return resultBalance;
    }

    public void setResultBalance(int resultBalance) {
        this.resultBalance = resultBalance;
    }

    public int getOpenid() {
        return openid;
    }

    public void setOpenid(int openid) {
        this.openid = openid;
    }
}
