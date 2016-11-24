package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/18.
 * 团购券
 */
public class GrouponCard extends Card {

    private Groupon groupon;

    public GrouponCard(){
        super(CARD_TYPE_GROUPON);
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public class Groupon {
        /**
         * base_info	是	JSON结构	见上述示例。	基本的卡券数据，见下表，所有卡券类型通用。
         */
        private BaseInfo baseInfo;
        private AdvancedInfo advancedInfo;
        /**
         * deal_detail	是	string(3072)	双人套餐\n -进口红酒一支。\n孜然牛肉一份。	团购券专用，团购详情。
         */
        private String dealDetail;

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

        public String getDealDetail() {
            return dealDetail;
        }

        public void setDealDetail(String dealDetail) {
            this.dealDetail = dealDetail;
        }
    }
}
