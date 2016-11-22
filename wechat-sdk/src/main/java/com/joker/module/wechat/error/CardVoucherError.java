package com.joker.module.wechat.error;

/**
 * Created by zhangjian on 2016/11/21.
 * 此类作为微信卡券操作错误返回对象用，目前只是备用，暂时写在这里
 */
public class CardVoucherError extends BaseError{

    private String cardId;


    public CardVoucherError(String errcode, String errmsg, String cardId) {
        super(errcode, errmsg);
        this.cardId = cardId;
    }


    public CardVoucherError() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
