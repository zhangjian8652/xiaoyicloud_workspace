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
    private String color;
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
     *
     */
    private String servicePhone;

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
    private int getLimit;
    private boolean useCustomCode;
    private boolean bindOpenid;
    private boolean canShare;
    private boolean canGivenFriend;

    private List<Integer> locationIdList;

    private String centerTitle;
    private String centerSubTitle;
    private String centerUrl;
    private String customUrlName;
    private String customUrl;
    private String customUrlSubTitle;
    private String promotionUrlName;
    private String promotionUrl;
    private String source;



    public static class Color{
        public static String COLOR_010 = "Color010";
        public static String COLOR_020 = "Color020";
        public static String COLOR_030 = "Color030";
        public static String COLOR_040 = "Color040";
        public static String COLOR_050 = "Color050";
        public static String COLOR_060 = "Color060";
        public static String COLOR_070 = "Color070";
        public static String COLOR_080 = "Color080";
        public static String COLOR_090 = "Color090";
        public static String COLOR_100 = "Color100";
        public static String COLOR_101 = "Color101";
        public static String COLOR_102 = "Color102";
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
        private String type;

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





    }

    public class Sku {
        /**
         * quantity	是	int	100000	卡券库存的数量，上限为100000000。
         */
        private int quantity;
    }
    public static class DateType{

        public static String FIX_TIME_RANGE = "DATE_TYPE_FIX_TIME_RANGE";
        public static String FIX_TERM = "DATE_TYPE_FIX_TERM";
    }

}
