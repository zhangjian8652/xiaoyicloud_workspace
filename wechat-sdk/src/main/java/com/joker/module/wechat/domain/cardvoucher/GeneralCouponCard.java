package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/18.
 * 优惠券
 */
public class GeneralCouponCard extends Card{

    private GeneralCoupon generalCoupon;

    public GeneralCouponCard() {
        super(CARD_TYPE_GENERAL_COUPON);
    }


    public GeneralCoupon getGeneralCoupon() {
        return generalCoupon;
    }

    public void setGeneralCoupon(GeneralCoupon generalCoupon) {
        this.generalCoupon = generalCoupon;
    }

    public class GeneralCoupon{
        private BaseInfo baseInfo;
        private AdvancedInfo advancedInfo;
        /**
         * default_detail	是	string(3072)	音乐木盒。	优惠券专用，填写优惠详情。
         */
        private String defaultDetail;

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

        public String getDefaultDetail() {
            return defaultDetail;
        }

        public void setDefaultDetail(String defaultDetail) {
            this.defaultDetail = defaultDetail;
        }
    }


}
