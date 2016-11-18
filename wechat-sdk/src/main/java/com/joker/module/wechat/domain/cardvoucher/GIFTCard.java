package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class GIFTCard extends Card {



    public GIFTCard() {
        super(CARD_TYPE_GIFT);
    }

    public class GIFT{
        private BaseInfo baseInfo;
        private AdvancedInfo advancedInfo;
        /**
         * gift	是	string(3072)	可兑换音乐木盒一个。	兑换券专用，填写兑换内容的名称。
         */
        private String gift;

        public BaseInfo getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(BaseInfo baseInfo) {
            this.baseInfo = baseInfo;
        }

        public AdvancedInfo getAdvancedInfo() {
            return advancedInfo;
        }

        public void setAdvancedInfo(AdvancedInfo advancedInfo) {
            this.advancedInfo = advancedInfo;
        }

        public String getGift() {
            return gift;
        }

        public void setGift(String gift) {
            this.gift = gift;
        }
    }

}
