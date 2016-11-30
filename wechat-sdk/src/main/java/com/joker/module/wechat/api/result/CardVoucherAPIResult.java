package com.joker.module.wechat.api.result;

/**
 * Created by zhangjian on 2016/11/21.
 * 此类作为微信卡券操作错误返回对象用，目前只是备用，暂时写在这里
 */
public class CardVoucherAPIResult extends BaseResult {

    private String cardId;


    public CardVoucherAPIResult(Integer errcode, String errmsg, String cardId) {
        super(errcode, errmsg);
        this.cardId = cardId;
    }


    public CardVoucherAPIResult() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
