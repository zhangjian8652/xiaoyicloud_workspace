package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/29.
 */
public class MemberCardUpdateInfo {

    /**
     * code            	是            	string(20)            	1231123            	卡券Code码。
     */
    private String code;
    /**
     * card_id            	是            	string（32）p1Pj9jr90_SRaVqYI239Ka1erkI    卡券ID。
     */
    private String cardId;
    /**
     * background_pic_url       否            	string（128）   https://mmbiz.qlogo.cn/     支持商家激活时针对单个会员卡分配自定义的会员卡背景。
     */
    private String backgroundPicUrl;
    /**
     * bonus            	否            	int            	100            	需要设置的积分全量值，传入的数值会直接显示
     */
    private Integer bonus;

    /**
     * record_bonus            	否            	string(42)            	消费30元，获得3积分            	商家自定义积分消耗记录，不超过14个汉字。
     */
    private String recordBonus;
    /**
     * balance            	否           	int            	100            	需要设置的余额全量值，传入的数值会直接显示
     */
    private String balance;
    /**
     * record_balance            	否            	string(42)   购买焦糖玛琪朵一杯，扣除金额30元。   商家自定义金额消耗记录，不超过14个汉字。
     */
    private String recordBalance;

    /**
     * custom_field_value1            	否            	string（12）            	白金            	创建时字段custom_field1定义类型的最新数值，限制为4个汉字，12字节。
     */
    private String customFieldValue1;
    private String customFieldValue2;
    private String customFieldValue3;
    private NotifyOptional notifyOptional;





    public class NotifyOptional {
        /**
         *
         is_notify_bonus 否	bool	true	积分变动时是否触发系统模板消息，默认为true
         */
        private boolean isNotifyBonus;

        /**
         * is_notify_balance	否	bool	true	余额变动时是否触发系统模板消息，默认为true
         */
        private boolean isNotifyBalance;

        /**
         * is_notify_custom_field1	否	bool	false	自定义group1变动时是否触发系统模板消息，默认为false。（2、3同理）
         */
        private boolean isNotifyCustomField1;
        private boolean isNotifyCustomField2;
        private boolean isNotifyCustomField3;


        public NotifyOptional() {
        }

        public NotifyOptional(boolean isNotifyBonus, boolean isNotifyBalance, boolean isNotifyCustomField1, boolean isNotifyCustomField2, boolean isNotifyCustomField3) {
            this.isNotifyBonus = isNotifyBonus;
            this.isNotifyBalance = isNotifyBalance;
            this.isNotifyCustomField1 = isNotifyCustomField1;
            this.isNotifyCustomField2 = isNotifyCustomField2;
            this.isNotifyCustomField3 = isNotifyCustomField3;
        }

        public boolean isNotifyBonus() {
            return isNotifyBonus;
        }

        public void setNotifyBonus(boolean notifyBonus) {
            isNotifyBonus = notifyBonus;
        }

        public boolean isNotifyBalance() {
            return isNotifyBalance;
        }

        public void setNotifyBalance(boolean notifyBalance) {
            isNotifyBalance = notifyBalance;
        }

        public boolean isNotifyCustomField1() {
            return isNotifyCustomField1;
        }

        public void setNotifyCustomField1(boolean notifyCustomField1) {
            isNotifyCustomField1 = notifyCustomField1;
        }

        public boolean isNotifyCustomField2() {
            return isNotifyCustomField2;
        }

        public void setNotifyCustomField2(boolean notifyCustomField2) {
            isNotifyCustomField2 = notifyCustomField2;
        }

        public boolean isNotifyCustomField3() {
            return isNotifyCustomField3;
        }

        public void setNotifyCustomField3(boolean notifyCustomField3) {
            isNotifyCustomField3 = notifyCustomField3;
        }
    }
}
