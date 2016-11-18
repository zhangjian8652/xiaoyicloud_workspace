package com.joker.module.wechat.domain.cardvoucher;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class AdvancedInfo {
    private UseCondition useCondition;
    @JsonProperty("abstract")
    private Abstract anAbstract;

    private TextImage[] textImageList;

    private TimeLimit timeLimit;

    private String[] businessService;


    public class Abstract {

        @JsonProperty("abstract")
        private String abstrac;

        private String[] iconUrlList;

    }


    public class TextImage {
        private String imageUrl;
        private String text;
    }

    public class TimeLimit {
        private String type;
        private int beginHour;
        private int endHour;
        private int beginMinute;
        private int endMinute;
    }

    public class UseCondition {
        private String acceptCategory;
        private String rejectCategory;
        private boolean canUseWithOtherDiscount;
    }



}
