package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/30.
 */
public class CardNode<T> {
    private T card;

    public CardNode(T card) {
        this.card = card;
    }

    public T getCard() {
        return card;
    }

    public void setCard(T card) {
        this.card = card;
    }
}
