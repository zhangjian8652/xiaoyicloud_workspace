package com.joker.module.wechat.domain.cardvoucher;

import java.io.Serializable;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class Card implements Serializable{

    public static String CARD_TYPE_GROUPON = "GROUPON";
    public static String CARD_TYPE_CASH = "CASH";
    public static String CARD_TYPE_DISCOUNT = "DISCOUNT";
    public static String CARD_TYPE_MEMBER_CARD = "MEMBER_CARD";
    public static String CARD_TYPE_GIFT = "GIFT";
    public static String CARD_TYPE_GENERAL_COUPON = "GENERAL_COUPON";

    /**
     * card_type	是	string(24)	GROUPON	团购券类型。
     */
    private String cardType;

    public Card(String cardType) {
        this.cardType = cardType;
    }

    public Card() {
    }
}
