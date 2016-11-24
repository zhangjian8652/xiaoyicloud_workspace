package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/22.
 *
 * 会员卡
 */
public class MemberCard extends Card {


    private Member memberCard;

    public MemberCard() {
        super(CARD_TYPE_MEMBER_CARD);
    }

    public Member getMemberCard() {
        return memberCard;
    }

    public void setMemberCard(Member memberCard) {
        this.memberCard = memberCard;
    }

    public class Member{
        private BaseInfo baseInfo;
        private boolean supplyBonus;
        private boolean supplyBalance;
        private String prerogative;
        private boolean autoActivate;
        private CustomField customField1;

        /**
         * 是	string（128）	xxx.com	激活会员卡的url。
         */
        private String activateUrl;

        /**
         * 否	bool	true	设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。填入该字段后仍需调用接口设置开卡项方可生效，详情见一键开卡。
         */
        private String wxActivate;
        /**
         * 否	string(32)	xxxx.com	设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
         */
        private String bonusUrl;

        /**
         * 	否	string(32)	xxxx.com	设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段。
         */
        private String balanceUrl;

        /**
         * 	否	string（128）	每年年底12月30号积分清0。	积分清零规则。
         */
        private String bonusCleared;

        /**
         * 否	string（128）	每消费一元获取1点积分。	积分规则。
         */
        private String bonusRules;

        /**
         * 否	string（128）	xxx.com	储值说明。
         */
        private String balanceRules;


        private CustomCell customCell1;
        private BonusRule bonusRule;

        /**
         * 	否	int	10	折扣，该会员卡享受的折扣优惠,填10就是九折。
         */
        private int discount;




        /**
         *
         * @param baseInfo
         * @param supplyBonus 	是	bool	true	显示积分，填写true或false，如填写true，积分相关字段均为必填
         * @param supplyBalance 是	bool	true	是否支持储值，填写true或false。如填写true，储值相关字段均为必填。
         * @param prerogative 	是	string（3072）	持白金会员卡到店消费，可享8折优惠。	会员卡特权说明。
         * @param autoActivate 	否	bool	true	设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口，详情见自动激活。
         * @param customField1
         * @param activateUrl 是	 string（128）	xxx.com	激活会员卡的url。
         * @param customCell1
         * @param bonusRule
         * @param discount 	否	int	10	折扣，该会员卡享受的折扣优惠,填10就是九折。
         */
        public Member(BaseInfo baseInfo, boolean supplyBonus, boolean supplyBalance, String prerogative, boolean autoActivate, CustomField customField1, String activateUrl, CustomCell customCell1, BonusRule bonusRule, int discount) {
            this.baseInfo = baseInfo;
            this.supplyBonus = supplyBonus;
            this.supplyBalance = supplyBalance;
            this.prerogative = prerogative;
            this.autoActivate = autoActivate;
            this.customField1 = customField1;
            this.activateUrl = activateUrl;
            this.customCell1 = customCell1;
            this.bonusRule = bonusRule;
            this.discount = discount;
        }

        public Member() {
        }

        public BaseInfo getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(BaseInfo baseInfo) {
            this.baseInfo = baseInfo;
        }

        public boolean isSupplyBonus() {
            return supplyBonus;
        }

        public void setSupplyBonus(boolean supplyBonus) {
            this.supplyBonus = supplyBonus;
        }

        public boolean isSupplyBalance() {
            return supplyBalance;
        }

        public void setSupplyBalance(boolean supplyBalance) {
            this.supplyBalance = supplyBalance;
        }

        public String getPrerogative() {
            return prerogative;
        }

        public void setPrerogative(String prerogative) {
            this.prerogative = prerogative;
        }

        public boolean isAutoActivate() {
            return autoActivate;
        }

        public void setAutoActivate(boolean autoActivate) {
            this.autoActivate = autoActivate;
        }

        public CustomField getCustomField1() {
            return customField1;
        }

        public void setCustomField1(CustomField customField1) {
            this.customField1 = customField1;
        }

        public String getActivateUrl() {
            return activateUrl;
        }

        public void setActivateUrl(String activateUrl) {
            this.activateUrl = activateUrl;
        }

        public String getWxActivate() {
            return wxActivate;
        }

        public void setWxActivate(String wxActivate) {
            this.wxActivate = wxActivate;
        }

        public String getBonusUrl() {
            return bonusUrl;
        }

        public void setBonusUrl(String bonusUrl) {
            this.bonusUrl = bonusUrl;
        }

        public String getBalanceUrl() {
            return balanceUrl;
        }

        public void setBalanceUrl(String balanceUrl) {
            this.balanceUrl = balanceUrl;
        }

        public String getBonusCleared() {
            return bonusCleared;
        }

        public void setBonusCleared(String bonusCleared) {
            this.bonusCleared = bonusCleared;
        }

        public String getBonusRules() {
            return bonusRules;
        }

        public void setBonusRules(String bonusRules) {
            this.bonusRules = bonusRules;
        }

        public String getBalanceRules() {
            return balanceRules;
        }

        public void setBalanceRules(String balanceRules) {
            this.balanceRules = balanceRules;
        }

        public CustomCell getCustomCell1() {
            return customCell1;
        }

        public void setCustomCell1(CustomCell customCell1) {
            this.customCell1 = customCell1;
        }

        public BonusRule getBonusRule() {
            return bonusRule;
        }

        public void setBonusRule(BonusRule bonusRule) {
            this.bonusRule = bonusRule;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }
    }


    public class CustomField{
        /**
         * 否	string(24)	FIELD_NAME_TYPE_LEVEL	会员信息类目名称。FIELD_NAME_TYPE_LEVEL等级；FIELD_NAME_TYPE_COUPON优惠券；FIELD_NAME_TYPE_STAMP印花；FIELD_NAME_TYPE_DISCOUNT折扣；FIELD_NAME_TYPE_ACHIEVEMEN成就；FIELD_NAME_TYPE_MILEAGE里程。
         */
        private CustomFieldNameType nameType;

        /**
         * 	否	string（128）	xxx.com	点击类目跳转外链url
         */
        private String url;

        /**
         *
         * @param nameType 	否	string(24)	FIELD_NAME_TYPE_LEVEL	会员信息类目名称。FIELD_NAME_TYPE_LEVEL等级；FIELD_NAME_TYPE_COUPON优惠券；FIELD_NAME_TYPE_STAMP印花；FIELD_NAME_TYPE_DISCOUNT折扣；FIELD_NAME_TYPE_ACHIEVEMEN成就；FIELD_NAME_TYPE_MILEAGE里程。
         * @param url 	否	string（128）	xxx.com	点击类目跳转外链url
         */
        public CustomField(CustomFieldNameType nameType, String url) {
            this.nameType = nameType;
            this.url = url;
        }

        public CustomField() {
        }

        public CustomFieldNameType getNameType() {
            return nameType;
        }

        public void setNameType(CustomFieldNameType nameType) {
            this.nameType = nameType;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public enum CustomFieldNameType{
        /**
         * 会员信息类目名称。FIELD_NAME_TYPE_LEVEL等级；FIELD_NAME_TYPE_COUPON优惠券；FIELD_NAME_TYPE_STAMP印花；FIELD_NAME_TYPE_DISCOUNT折扣；FIELD_NAME_TYPE_ACHIEVEMEN成就；FIELD_NAME_TYPE_MILEAGE里程。
         */
        FIELD_NAME_TYPE_LEVEL,FIELD_NAME_TYPE_COUPON,FIELD_NAME_TYPE_STAMP,FIELD_NAME_TYPE_DISCOUNT,FIELD_NAME_TYPE_ACHIEVEMEN,FIELD_NAME_TYPE_MILEAGE
    }

    public class CustomCell{
        /**
         * 是	string（15）	见上述示例。	入口名称。
         */
        private String name;

        /**
         * 是	string（18）	立即查看	入口右侧提示语，6个汉字内。
         */
        private String tips;

        /**
         * 是	string（128）	xxx.com	入口跳转链接。
         */
        private String url;

        /**
         *
         * @param name 是	string（15）	见上述示例。	入口名称。
         * @param tips 	是	string（18）	立即查看	入口右侧提示语，6个汉字内。
         * @param url 	是	string（128）	xxx.com	入口跳转链接。
         */
        public CustomCell(String name, String tips, String url) {
            this.name = name;
            this.tips = tips;
            this.url = url;
        }

        public CustomCell() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class BonusRule{

        /**
         * 否	int	100	消费金额。以分为单位
         */
        private int costMoneyUnit;

        /**
         * 否	int	100	对应增加的积分。
         */
        private int increaseBonus;

        /**
         * 否	int	10000	用户单次可获取的积分上限。
         */
        private int maxIncreaseBonus;

        /**
         * 否	int	10	初始设置积分。
         */
        private int initIncreaseBonus;

        /**
         * 否	int	10	每使用5积分。
         */
        private int costBonusUnit;

        /**
         * 否	int	10	抵扣xx元，（这里以分为单位）
         */
        private int reduceMoney;

        /**
         * 否	int	100	抵扣条件，满xx元（这里以分为单位）可用。
         */
        private int leastMoneyToUseBonus;

        /**
         * 否	int	10	抵扣条件，单笔最多使用xx积分
         */
        private int maxReduceBonus;

        /**
         *
         * @param costMoneyUnit 否	int	100	消费金额。以分为单位
         * @param increaseBonus 否	int	100	对应增加的积分。
         * @param maxIncreaseBonus 否	int	10000	用户单次可获取的积分上限。
         * @param initIncreaseBonus 否	int	10	初始设置积分。
         * @param costBonusUnit 否	int	10	每使用5积分。
         * @param reduceMoney 否	int	10	抵扣xx元，（这里以分为单位）
         * @param leastMoneyToUseBonus 否	int	100	抵扣条件，满xx元（这里以分为单位）可用。
         * @param maxReduceBonus 否	int	10	抵扣条件，单笔最多使用xx积分
         */
        public BonusRule(int costMoneyUnit, int increaseBonus, int maxIncreaseBonus, int initIncreaseBonus, int costBonusUnit, int reduceMoney, int leastMoneyToUseBonus, int maxReduceBonus) {
            this.costMoneyUnit = costMoneyUnit;
            this.increaseBonus = increaseBonus;
            this.maxIncreaseBonus = maxIncreaseBonus;
            this.initIncreaseBonus = initIncreaseBonus;
            this.costBonusUnit = costBonusUnit;
            this.reduceMoney = reduceMoney;
            this.leastMoneyToUseBonus = leastMoneyToUseBonus;
            this.maxReduceBonus = maxReduceBonus;
        }

        public BonusRule() {
        }

        public int getCostMoneyUnit() {
            return costMoneyUnit;
        }

        public void setCostMoneyUnit(int costMoneyUnit) {
            this.costMoneyUnit = costMoneyUnit;
        }

        public int getIncreaseBonus() {
            return increaseBonus;
        }

        public void setIncreaseBonus(int increaseBonus) {
            this.increaseBonus = increaseBonus;
        }

        public int getMaxIncreaseBonus() {
            return maxIncreaseBonus;
        }

        public void setMaxIncreaseBonus(int maxIncreaseBonus) {
            this.maxIncreaseBonus = maxIncreaseBonus;
        }

        public int getInitIncreaseBonus() {
            return initIncreaseBonus;
        }

        public void setInitIncreaseBonus(int initIncreaseBonus) {
            this.initIncreaseBonus = initIncreaseBonus;
        }

        public int getCostBonusUnit() {
            return costBonusUnit;
        }

        public void setCostBonusUnit(int costBonusUnit) {
            this.costBonusUnit = costBonusUnit;
        }

        public int getReduceMoney() {
            return reduceMoney;
        }

        public void setReduceMoney(int reduceMoney) {
            this.reduceMoney = reduceMoney;
        }

        public int getLeastMoneyToUseBonus() {
            return leastMoneyToUseBonus;
        }

        public void setLeastMoneyToUseBonus(int leastMoneyToUseBonus) {
            this.leastMoneyToUseBonus = leastMoneyToUseBonus;
        }

        public int getMaxReduceBonus() {
            return maxReduceBonus;
        }

        public void setMaxReduceBonus(int maxReduceBonus) {
            this.maxReduceBonus = maxReduceBonus;
        }
    }
}
