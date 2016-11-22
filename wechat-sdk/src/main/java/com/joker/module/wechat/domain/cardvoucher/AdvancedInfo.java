package com.joker.module.wechat.domain.cardvoucher;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class AdvancedInfo {

    /**
     * 字段： use_condition
     *
     * 必填： 否
     *
     * 类型：JSON结构
     *
     * 说明： 使用门槛（条件）字段，若不填写使用条件则在券面拼写
     * ：无最低消费限制，全场通用，不限品类；并在使用说明显示：
     * 可与其他优惠共享
     */
    private UseCondition useCondition;

    /**
     *
     */

    @JsonProperty("abstract")
    private Abstract anAbstract;

    /**
     * text_image_list
     *
     * 否
     *
     * JSON结构
     *
     * 图文列表，显示在详情内页
     * ，优惠券券开发者须至少传入
     * 一组图文列表
     */
    private TextImage[] textImageList;

    /**
     * time_limit
     *
     * 否
     *
     * JSON结构
     *
     * 使用时段限制，包含以下字段
     */

    private TimeLimit timeLimit;

    /**
     * business_service
     *
     * 否
     *
     * arry
     *
     * 商家服务类型：
     * BIZ_SERVICE_DELIVER 外卖服务；
     * BIZ_SERVICE_FREE_PARK 停车位；
     * BIZ_SERVICE_WITH_PET 可带宠物；
     * BIZ_SERVICE_FREE_WIFI 免费wifi，
     * 可多选
     */
    private BusinessService[] businessService;


    /**
     *
     * @param useCondition 可选 说明： 使用门槛（条件）字段，若不填写使用条件则在券面拼写
     *                     ：无最低消费限制，全场通用，不限品类；并在使用说明显示：
     *                     可与其他优惠共享
     * @param anAbstract
     * @param textImageList 可选 图文列表，显示在详情内页
     *                      ，优惠券券开发者须至少传入
     *                      一组图文列表
     * @param timeLimit 可选 使用时段限制，包含以下字段
     * @param businessService 可选 商家服务类型：
     *                        BIZ_SERVICE_DELIVER 外卖服务；
     *                        BIZ_SERVICE_FREE_PARK 停车位；
     *                        BIZ_SERVICE_WITH_PET 可带宠物；
     *                        BIZ_SERVICE_FREE_WIFI 免费wifi，
     *                        可多选
     */
    public AdvancedInfo(UseCondition useCondition, Abstract anAbstract, TextImage[] textImageList, TimeLimit timeLimit, BusinessService[] businessService) {
        this.useCondition = useCondition;
        this.anAbstract = anAbstract;
        this.textImageList = textImageList;
        this.timeLimit = timeLimit;
        this.businessService = businessService;
    }


    public AdvancedInfo() {
    }


    public UseCondition getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(UseCondition useCondition) {
        this.useCondition = useCondition;
    }

    public Abstract getAnAbstract() {
        return anAbstract;
    }

    public void setAnAbstract(Abstract anAbstract) {
        this.anAbstract = anAbstract;
    }

    public TextImage[] getTextImageList() {
        return textImageList;
    }

    public void setTextImageList(TextImage[] textImageList) {
        this.textImageList = textImageList;
    }

    public TimeLimit getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(TimeLimit timeLimit) {
        this.timeLimit = timeLimit;
    }

    public BusinessService[] getBusinessService() {
        return businessService;
    }

    public void setBusinessService(BusinessService[] businessService) {
        this.businessService = businessService;
    }

    public class Abstract {

        @JsonProperty("abstract")
        private String abstrac;
        private String[] iconUrlList;


        /**
         *
         * @param abstrac 可选 长度24 封面摘要简介。
         * @param iconUrlList 可选 长度128 封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350
         */
        public Abstract(String abstrac, String[] iconUrlList) {
            this.abstrac = abstrac;
            this.iconUrlList = iconUrlList;
        }

        public Abstract() {
        }

        public String getAbstrac() {
            return abstrac;
        }

        public void setAbstrac(String abstrac) {
            this.abstrac = abstrac;
        }

        public String[] getIconUrlList() {
            return iconUrlList;
        }

        public void setIconUrlList(String[] iconUrlList) {
            this.iconUrlList = iconUrlList;
        }
    }


    public class TextImage {

        private String imageUrl;

        private String text;

        /**
         * @param imageUrl  可选 长度128 图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错
         * @param text 可选 长度512 图文描述
         */
        public TextImage(String imageUrl, String text) {
            this.imageUrl = imageUrl;
            this.text = text;
        }

        public TextImage() {
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public class TimeLimit {

        /**
         * type
         *
         * 否
         *
         * string（24）
         *
         * 限制类型枚举值：支持填入
         * MONDAY 周一
         * TUESDAY 周二
         * WEDNESDAY 周三
         * THURSDAY 周四
         * FRIDAY 周五
         * SATURDAY 周六
         * SUNDAY 周日
         * 此处只控制显示，
         * 不控制实际使用逻辑，不填默认不显示
         */
        private TimeLimitType type;

        /**
         * begin_hour
         *
         * 否
         *
         * int
         *
         * 当前type类型下的起始时间（小时）
         * ，如当前结构体内填写了MONDAY，
         * 此处填写了10，则此处表示周一 10:00可用
         */
        private int beginHour;

        /**
         * begin_minute
         *
         * 否
         *
         * int
         *
         *
         * 当前type类型下的起始时间（分钟）
         * ，如当前结构体内填写了MONDAY，
         * begin_hour填写10，此处填写了59，
         * 则此处表示周一 10:59可用
         */
        private int beginMinute;

        /**
         * end_hour
         *
         * 否
         *
         * int
         *
         * 当前type类型下的结束时间（小时）
         * ，如当前结构体内填写了MONDAY，
         * 此处填写了20，则此处表示周一 10:00-20:00可用
         *
         */
        private int endHour;

        /**
         * end_minute
         *
         * 否
         *
         * int
         *
         * 当前type类型下的结束时间（分钟）
         * ，如当前结构体内填写了MONDAY，
         * begin_hour填写10，此处填写了59，
         * 则此处表示周一 10:59-00:59可用
         */
        private int endMinute;


        /**
         *
         * @param type 时间周一到周日从枚举 AdvancedIndo.TimeLimitType取值
         *             （ 限制类型枚举值：支持填入
         *                MONDAY 周一
         *                TUESDAY 周二
         *                WEDNESDAY 周三
         *                THURSDAY 周四
         *                FRIDAY 周五
         *                SATURDAY 周六
         *                SUNDAY 周日
         *                此处只控制显示，
         *                不控制实际使用逻辑，不填默认不显示）
         * @param beginHour 当前type类型下的起始时间（小时），如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用
         * @param beginMinute  当前type类型下的起始时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用
         * @param endHour 当前type类型下的结束时间（小时），如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用
         * @param endMinute 当前type类型下的结束时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用
         */
        public TimeLimit(TimeLimitType type, int beginHour, int beginMinute, int endHour, int endMinute) {
            this.type = type;
            this.beginHour = beginHour;
            this.beginMinute = beginMinute;
            this.endHour = endHour;
            this.endMinute = endMinute;
        }

        public TimeLimit() {
        }

        public TimeLimitType getType() {
            return type;
        }

        public void setType(TimeLimitType type) {
            this.type = type;
        }

        public int getBeginHour() {
            return beginHour;
        }

        public void setBeginHour(int beginHour) {
            this.beginHour = beginHour;
        }

        public int getBeginMinute() {
            return beginMinute;
        }

        public void setBeginMinute(int beginMinute) {
            this.beginMinute = beginMinute;
        }

        public int getEndHour() {
            return endHour;
        }

        public void setEndHour(int endHour) {
            this.endHour = endHour;
        }

        public int getEndMinute() {
            return endMinute;
        }

        public void setEndMinute(int endMinute) {
            this.endMinute = endMinute;
        }
    }

    public class UseCondition {
        /**
         * accept_category
         *
         * 否
         *
         * string（512）
         *
         * 指定可用的商品类目，仅用于代金券类型
         * ，填入后将在券面拼写适用于xxx
         */
        private String acceptCategory;

        /**
         * reject_category
         *
         * 否
         *
         * string（512）
         *
         * 指定不可用的商品类目，仅用于代金券类型
         * ，填入后将在券面拼写不适用于xxxx
         */
        private String rejectCategory;


        /**
         * least_cost
         *
         * 否
         *
         * int
         *
         * 满减门槛字段，可用于兑换券和代金券
         * ，填入后将在全面拼写消费满xx元可用。
         */
        private int leastCost;

        /**
         * object_use_for
         *
         * 否
         *
         * string（512）
         *
         * 购买xx可用类型门槛，仅用于兑换
         * ，填入后自动拼写购买xxx可用。
         */
        private String objectUseFor;

        /**
         * can_use_with_other_discount
         *
         * 否
         *
         * bool
         *
         * 不可以与其他类型共享门槛
         * ，填写false时系统将在使用须知里
         * 拼写“不可与其他优惠共享”，
         * 填写true时系统将在使用须知里
         * 拼写“可与其他优惠共享”，
         * 默认为true
         */
        private boolean canUseWithOtherDiscount;


        /**
         *
         * @param acceptCategory 可选 长度512 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
         * @param rejectCategory 可选 长度512 指定不可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
         * @param leastCost 可选 长度512 满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。
         * @param objectUseFor 可选 长度512 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。
         * @param canUseWithOtherDiscount 可选 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true
         *
         */
        public UseCondition(String acceptCategory, String rejectCategory, int leastCost, String objectUseFor, boolean canUseWithOtherDiscount) {
            this.acceptCategory = acceptCategory;
            this.rejectCategory = rejectCategory;
            this.leastCost = leastCost;
            this.objectUseFor = objectUseFor;
            this.canUseWithOtherDiscount = canUseWithOtherDiscount;
        }

        public UseCondition() {
        }

        public String getAcceptCategory() {
            return acceptCategory;
        }

        public void setAcceptCategory(String acceptCategory) {
            this.acceptCategory = acceptCategory;
        }

        public String getRejectCategory() {
            return rejectCategory;
        }

        public void setRejectCategory(String rejectCategory) {
            this.rejectCategory = rejectCategory;
        }

        public int getLeastCost() {
            return leastCost;
        }

        public void setLeastCost(int leastCost) {
            this.leastCost = leastCost;
        }

        public String getObjectUseFor() {
            return objectUseFor;
        }

        public void setObjectUseFor(String objectUseFor) {
            this.objectUseFor = objectUseFor;
        }

        public boolean isCanUseWithOtherDiscount() {
            return canUseWithOtherDiscount;
        }

        public void setCanUseWithOtherDiscount(boolean canUseWithOtherDiscount) {
            this.canUseWithOtherDiscount = canUseWithOtherDiscount;
        }
    }



    public enum BusinessService{
        BIZ_SERVICE_DELIVER,BIZ_SERVICE_FREE_PARK,BIZ_SERVICE_WITH_PET,BIZ_SERVICE_FREE_WIFI
    }

    public enum TimeLimitType{
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
}
