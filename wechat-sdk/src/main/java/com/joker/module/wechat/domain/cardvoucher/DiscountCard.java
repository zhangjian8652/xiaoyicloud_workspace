package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/22.
 * 折扣券
 */
public class DiscountCard extends Card{


    private Discount discount;

    public DiscountCard(Discount discount) {
        super(CARD_TYPE_DISCOUNT);
        this.discount = discount;
    }

    public DiscountCard() {
    }

    public class Discount{

        private BaseInfo baseInfo;

        /**
         * 	折扣券专用，表示打折额度（百分比）。填30就是七折。
         */
        private int discount;


        public BaseInfo getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(BaseInfo baseInfo) {
            this.baseInfo = baseInfo;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }
    }

}
