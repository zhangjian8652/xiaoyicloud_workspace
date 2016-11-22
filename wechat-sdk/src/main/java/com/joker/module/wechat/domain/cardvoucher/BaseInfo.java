package com.joker.module.wechat.domain.cardvoucher;

import java.util.List;

/**
 * Created by zhangjian on 2016/11/18.
 *
 * 卡券基础数据
 */
public class BaseInfo {

    /**
     * 注释字段解释：
     * 参数名
     * 必填
     * 类型
     * 示例值
     * 描述
     */


    //必填参数
    /**
     * logo_url
     *
     * 是
     *
     * string(128)
     *
     * http://mmbiz.qpic.cn/
     *
     * 卡券的商户logo，建议像素为300*300。
     */
    private String loginUrl;


    /**
     * brand_name
     *
     * 是
     *
     * string（36）
     *
     * 海底捞
     *
     * 商户名字,字数上限为12个汉字。
     */
    private String brandName;

    /**
     *
     * code_type
     *
     * 是
     *
     * string(16)
     *
     * CODE_TYPE_TEXT
     *
     * 码型：
     * "CODE_TYPE_TEXT"文本；
     * "CODE_TYPE_BARCODE"一维码
     * "CODE_TYPE_QRCODE"二维码
     * "CODE_TYPE_ONLY_QRCODE",二维码无code显示；
     * "CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE，
     * 不显示code和条形码类型
     */
    private String codeType;

    /**
     * title
     *
     * 是
     *
     * string（27）
     *
     * 双人套餐100元兑换券
     *
     * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
     */
    private String title;
    /**
     * color
     *
     * 是
     *
     * string（16）
     *
     * Color010
     *
     * 券颜色。按色彩规范标注填写Color010-Color100。
     */
    private Color color;
    /**
     *  notice
     *
     *  是
     *
     *  string（48）
     *
     *  请出示二维码
     *
     *  卡券使用提醒，字数上限为16个汉字。
     */
    private String notice;


    /**
     * description
     *
     * 是
     *
     * string
     *（3072）
     *
     * 不可与其他优惠同享
     *
     * 卡券使用说明，字数上限为1024个汉字。
     */
    private String description;

    /**
     * date_info
     *
     * 是
     *
     * JSON结构 见上述示例。
     *
     * 使用日期，有效期的信息。
     */
    private DateInfo dateInfo;

    /**
     * sku
     *
     * 是
     *
     * JSON结构	见上述示例。
     *
     * 商品信息。
     */
    private Sku sku;


    //可选参数

    /**
     * get_limit
     *
     * 否
     *
     * int
     *
     * 1
     *
     * 每人可领券的数量限制,不填写默认为50。
     */
    private int getLimit;

    /**
     * use_custom_code
     *
     * 否
     *
     * bool	true
     *
     * 是否自定义Code码
     * 。填写true或false，默认为false。
     * 通常自有优惠码系统的开发者选择
     * 自定义Code码，并在卡券投放时带入
     * Code码，详情见是否自定义Code码。
     */
    private boolean useCustomCode;


    /**
     * get_custom_code_mode
     *
     * 否
     *
     * string(32)
     *
     * GET_CUSTOM_COD
     * E_MODE_DEPOSIT
     *
     * 填入
     * GET_CUSTOM_CODE_MODE_DEPOSIT
     * 表示该卡券为预存code模式卡券，
     * 须导入超过库存数目的自定义code后方可投放，
     * 填入该字段后，quantity字段须为0,须导入code
     * 后再增加库存
     */
    private String getCustomCodeMode;

    /**
     * bind_openid
     *
     * 否
     *
     * bool	true
     *
     * 是否指定用户领取，填写true或false
     * 。默认为false。通常指定特殊用户群体
     * 投放卡券或防止刷券时选择指定用户领取。
     */
    private boolean bindOpenid;


    /**
     * service_phone
     *
     * 否
     *
     * string（24）
     *
     * 40012234
     *
     * 客服电话。
     */
    private String servicePhone;

    /**
     * can_share
     *
     * 否
     *
     * bool
     *
     * false
     *
     * 卡券领取页面是否可分享。
     */
    private boolean canShare;

    /**
     * can_give_friend
     *
     * 否
     *
     * bool
     *
     * false
     *
     * 卡券是否可转赠。
     */
    private boolean canGivenFriend;


    /**
     * location_id_list
     *
     * 否
     *
     * array
     *
     * 1234，2312
     *
     * 门店位置poiid。调用POI门店管理接
     * 口获取门店位置poiid。具备线下门店
     * 的商户为必填。
     */
    private List<Integer> locationIdList;

    /**
     * use_all_locations
     * 否
     *
     * bool
     *
     * true
     *
     * 设置本卡券支持全部门店，与location_id_list互斥
     */
    private boolean useAllLocations;


    /**
     * source
     *
     * 否
     *
     * string（36）
     *
     * 大众点评
     *
     * 第三方来源名，例如同程旅游、大众点评。
     */
    private String source;


    /**
     * custom_url_name
     *
     * 否
     *
     * string（15）
     *
     * 立即使用
     *
     * 自定义跳转外链的入口名字
     * 。详情见活用自定义入口
     */
    private String customUrlName;

    /**
     * center_title
     *
     * 否
     *
     * string（18）
     *
     * 立即使用
     *
     * 卡券顶部居中的按钮，仅在卡券状
     * 态正常(可以核销)时显示
     */
    private String centerTitle;

    /**
     * center_sub_title
     *
     * 否
     *
     * string（24）
     *
     * 立即享受优惠
     *
     * 显示在入口下方的提示语
     * ，仅在卡券状态正常(可以核销)时显示。
     */
    private String centerSubTitle;

    /**
     * center_url
     *
     * 否
     *
     * string（128）
     *
     * www.qq.com
     *
     * 顶部居中的url
     * ，仅在卡券状态正常(可以核销)时显示。
     */
    private String centerUrl;

    /**
     * custom_url
     *
     * 否
     *
     * string（128）
     *
     * www.qq.com
     *
     * 自定义跳转的URL。
     */
    private String customUrl;

    /**
     * custom_url_sub_title
     *
     * 否
     *
     * string（18）
     *
     * 更多惊喜
     *
     * 显示在入口右侧的提示语。
     */
    private String customUrlSubTitle;

    /**
     * promotion_url_name
     *
     * 否
     *
     * string（15）
     *
     * 产品介绍
     *
     * 营销场景的自定义入口名称。
     */
    private String promotionUrlName;

    /**
     * promotion_url
     *
     * 否
     *
     * string（128）
     *
     * www.qq.com
     *
     * 入口跳转外链的地址链接。
     */
    private String promotionUrl;


    /**
     * promotion_url_sub_title
     *
     * 否
     *
     * string（18）
     *
     * 卖场大优惠。
     *
     * 显示在营销入口右侧的提示语。
     */
    private String promotionUrlSubTitle;




    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateInfo getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(DateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public int getGetLimit() {
        return getLimit;
    }

    public void setGetLimit(int getLimit) {
        this.getLimit = getLimit;
    }

    public boolean isUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public String getGetCustomCodeMode() {
        return getCustomCodeMode;
    }

    public void setGetCustomCodeMode(String getCustomCodeMode) {
        this.getCustomCodeMode = getCustomCodeMode;
    }

    public boolean isBindOpenid() {
        return bindOpenid;
    }

    public void setBindOpenid(boolean bindOpenid) {
        this.bindOpenid = bindOpenid;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public boolean isCanShare() {
        return canShare;
    }

    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    public boolean isCanGivenFriend() {
        return canGivenFriend;
    }

    public void setCanGivenFriend(boolean canGivenFriend) {
        this.canGivenFriend = canGivenFriend;
    }

    public List<Integer> getLocationIdList() {
        return locationIdList;
    }

    public void setLocationIdList(List<Integer> locationIdList) {
        this.locationIdList = locationIdList;
    }

    public boolean isUseAllLocations() {
        return useAllLocations;
    }

    public void setUseAllLocations(boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCustomUrlName() {
        return customUrlName;
    }

    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }

    public String getCenterTitle() {
        return centerTitle;
    }

    public void setCenterTitle(String centerTitle) {
        this.centerTitle = centerTitle;
    }

    public String getCenterSubTitle() {
        return centerSubTitle;
    }

    public void setCenterSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }

    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }

    public String getPromotionUrlName() {
        return promotionUrlName;
    }

    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }

    public String getPromotionUrl() {
        return promotionUrl;
    }

    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    public String getPromotionUrlSubTitle() {
        return promotionUrlSubTitle;
    }

    public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
    }

    public enum Color{
       COLOR010,COLOR020,COLOR030,COLOR040,COLOR050,COLOR060,COLOR070,COLOR080,COLOR090,COLOR100,COLOR101,COLOR102
    }



    public class DateInfo {
        /**
         * type
         *
         * 是
         *
         * string
         *
         * DATE_TYPE_FIX
         * _TIME_RANGE
         * 表示固定日期区间，DATE_TYPE_FIX_TERM
         * 表示固定时长
         *（自领取后按天算。
         *
         * 使用时间的类型，旧文档采用的1和2依然生效。
         */
        private DateType type;

        /**
         * begin_timestamp
         *
         * 是
         *
         * unsigned int
         *
         * 14300000
         *
         * type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间,
         */
        private long beginTimestamp;

        /**
         * end_timestamp
         *
         * 是
         *
         * unsigned int
         *
         * 15300000
         *
         * 表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间,UTC+8，单位为秒）
         *
         *
         * 可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间，建议设置为截止日期的23:59:59过期。（东八区时间,UTC+8，单位为秒），设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期
         */
        private long endTimestamp;


        /**
         * fixed_term
         *
         * 是
         *
         * int
         *
         * 15
         *
         * type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
         */
        private int fixedTerm;

        /**
         * fixed_begin_term
         *
         * 是
         *
         * int
         *
         * 0
         *
         * type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）
         */
        private int fixedBeginTerm;


        public DateType getType() {
            return type;
        }

        public void setType(DateType type) {
            this.type = type;
        }

        public long getBeginTimestamp() {
            return beginTimestamp;
        }

        public void setBeginTimestamp(long beginTimestamp) {
            this.beginTimestamp = beginTimestamp;
        }

        public long getEndTimestamp() {
            return endTimestamp;
        }

        public void setEndTimestamp(long endTimestamp) {
            this.endTimestamp = endTimestamp;
        }

        public int getFixedTerm() {
            return fixedTerm;
        }

        public void setFixedTerm(int fixedTerm) {
            this.fixedTerm = fixedTerm;
        }

        public int getFixedBeginTerm() {
            return fixedBeginTerm;
        }

        public void setFixedBeginTerm(int fixedBeginTerm) {
            this.fixedBeginTerm = fixedBeginTerm;
        }
    }

    public class Sku {
        /**
         * quantity	是	int	100000	卡券库存的数量，上限为100000000。
         */
        private int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
    public enum DateType{
       DATE_TYPE_FIX_TIME_RANGE,DATE_TYPE_FIX_TERM
    }

}
