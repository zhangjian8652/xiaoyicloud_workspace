package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/30.
 */
public class MemberCardActiveInfo {

    /**
     * card_id            	是            	string(32)            	卡券ID。
     */
    private String cardId;

    /**
     * service_statement
     * 否            	JSON结构
     * 服务声明，用于放置商户会员卡守
     *　则
     */
    private ServiceStatement serviceStatement;


    /**
     * bind_old_card            	否            	JSON结构            	绑定老会员链接
     */
    private BindOldCard bindOldCard;


    /**
     * required_form            	否            	JSON结构            	会员卡激活时的必填选项。
     */
    private RequiredForm requiredForm;

    /**
     * optional_form            	否            	JSON结构            	会员卡激活时的选填项。
     */
    private OptionalForm optionalForm;


    public MemberCardActiveInfo() {
    }

    public MemberCardActiveInfo(String cardId, ServiceStatement serviceStatement, BindOldCard bindOldCard, RequiredForm requiredForm, OptionalForm optionalForm) {
        this.cardId = cardId;
        this.serviceStatement = serviceStatement;
        this.bindOldCard = bindOldCard;
        this.requiredForm = requiredForm;
        this.optionalForm = optionalForm;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public ServiceStatement getServiceStatement() {
        return serviceStatement;
    }

    public void setServiceStatement(ServiceStatement serviceStatement) {
        this.serviceStatement = serviceStatement;
    }

    public BindOldCard getBindOldCard() {
        return bindOldCard;
    }

    public void setBindOldCard(BindOldCard bindOldCard) {
        this.bindOldCard = bindOldCard;
    }

    public RequiredForm getRequiredForm() {
        return requiredForm;
    }

    public void setRequiredForm(RequiredForm requiredForm) {
        this.requiredForm = requiredForm;
    }

    public OptionalForm getOptionalForm() {
        return optionalForm;
    }

    public void setOptionalForm(OptionalForm optionalForm) {
        this.optionalForm = optionalForm;
    }

    public class OptionalForm{

        private boolean canModify;
        private CommonFieldId[] commonFieldIdList;
        private String[] customFieldList;


        public OptionalForm() {
        }

        public OptionalForm(boolean canModify, CommonFieldId[] commonFieldIdList, String[] customFieldList) {
            this.canModify = canModify;
            this.commonFieldIdList = commonFieldIdList;
            this.customFieldList = customFieldList;
        }

        public boolean isCanModify() {
            return canModify;
        }

        public void setCanModify(boolean canModify) {
            this.canModify = canModify;
        }

        public CommonFieldId[] getCommonFieldIdList() {
            return commonFieldIdList;
        }

        public void setCommonFieldIdList(CommonFieldId[] commonFieldIdList) {
            this.commonFieldIdList = commonFieldIdList;
        }

        public String[] getCustomFieldList() {
            return customFieldList;
        }

        public void setCustomFieldList(String[] customFieldList) {
            this.customFieldList = customFieldList;
        }
    }

    public class RequiredForm {
        /**
         * can_modify	否	bool
         * 当前结构（required_form或者optional_form ）内
         * 的字段是否允许用户激活后再次修改，商户设置为true
         * 时，需要接收相应事件通知处理修改事件
         */
        private boolean canModify;

        /**
         * rich_field_list            	否            	arry            	自定义富文本类型，包含以下三个字段
         */
        private RichField[] richFieldList;

        /**
         * common_field_id_list            	否            	arry            	微信格式化的选项类型。见以下列表。
         */
        private CommonFieldId[] commonFieldIdList;


        public RequiredForm(boolean canModify, RichField[] richFieldList, CommonFieldId[] commonFieldIdList) {
            this.canModify = canModify;
            this.richFieldList = richFieldList;
            this.commonFieldIdList = commonFieldIdList;
        }

        public RequiredForm() {
        }

        public boolean isCanModify() {
            return canModify;
        }

        public void setCanModify(boolean canModify) {
            this.canModify = canModify;
        }

        public RichField[] getRichFieldList() {
            return richFieldList;
        }

        public void setRichFieldList(RichField[] richFieldList) {
            this.richFieldList = richFieldList;
        }

        public CommonFieldId[] getCommonFieldIdList() {
            return commonFieldIdList;
        }

        public void setCommonFieldIdList(CommonFieldId[] commonFieldIdList) {
            this.commonFieldIdList = commonFieldIdList;
        }
    }


    public enum CommonFieldId {

        /**
         * USER_FORM_INFO_FLAG_MOBILE            	手机号
         * USER_FORM_INFO_FLAG_SEX	性别
         * USER_FORM_INFO_FLAG_NAME            	姓名
         * USER_FORM_INFO_FLAG_BIRTHDAY            	生日
         * USER_FORM_INFO_FLAG_IDCARD            	身份证
         * USER_FORM_INFO_FLAG_EMAIL            	邮箱
         * USER_FORM_INFO_FLAG_LOCATION            	详细地址
         * USER_FORM_INFO_FLAG_EDUCATION_BACKGRO        	教育背景
         * USER_FORM_INFO_FLAG_CAREER            	职业
         * USER_FORM_INFO_FLAG_INDUSTRY            	行业
         * USER_FORM_INFO_FLAG_INCOME            	收入
         * USER_FORM_INFO_FLAG_HABIT            	兴趣爱好
         */
        USER_FORM_INFO_FLAG_MOBILE, USER_FORM_INFO_FLAG_SEX, USER_FORM_INFO_FLAG_NAME, USER_FORM_INFO_FLAG_BIRTHDAY, USER_FORM_INFO_FLAG_IDCARD, USER_FORM_INFO_FLAG_EMAIL, USER_FORM_INFO_FLAG_LOCATION, USER_FORM_INFO_FLAG_EDUCATION_BACKGRO, USER_FORM_INFO_FLAG_CAREER, USER_FORM_INFO_FLAG_INDUSTRY, USER_FORM_INFO_FLAG_INCOME, USER_FORM_INFO_FLAG_HABIT
    }

    public class RichField {

        /**
         * type     否            	string(32) 富文本类型
         * FORM_FIELD_RADIO   自定义单选
         * FORM_FIELD_SELECT   自定义选择项
         * FORM_FIELD_CHECK_BOX 自定义多选
         */
        private RichFieldType type;

        /**
         * name            	否            	string(32)            	字段名
         */
        private String name;

        /**
         * values            	否            	arry            	选择项
         */
        private String[] values;


        public RichField() {
        }

        public RichField(RichFieldType type, String name, String[] values) {
            this.type = type;
            this.name = name;
            this.values = values;
        }


        public RichFieldType getType() {
            return type;
        }

        public void setType(RichFieldType type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String[] getValues() {
            return values;
        }

        public void setValues(String[] values) {
            this.values = values;
        }
    }


    public enum RichFieldType {
        FORM_FIELD_RADIO, FORM_FIELD_SELECT, FORM_FIELD_CHECK_BOX
    }

    public class BindOldCard {
        /**
         * name            	否            	string(32)            	链接名称
         */
        private String name;
        /**
         * url            	否            	string(128)            	自定义url， 请填写http://或者https://开头的链接
         */
        private String url;


        public BindOldCard() {
        }

        public BindOldCard(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class ServiceStatement {
        /**
         * name            	否            	string(32)            	会员声明字段名称
         */
        private String name;

        /**
         * url            	否            	string(128)            	自定义url 请填写http://或者https://开头的链接
         */
        private String url;

        public ServiceStatement(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public ServiceStatement() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
