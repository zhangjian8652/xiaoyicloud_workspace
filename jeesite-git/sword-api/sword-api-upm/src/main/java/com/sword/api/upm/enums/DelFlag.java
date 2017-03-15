package com.sword.api.upm.enums;

/**
 * @Author zhangjian
 * @Date 2017/2/14
 * @Copyright:
 * @Describe:
 */
public enum DelFlag {
    DELETED("1"),NOT_DELETED("0");

    final String value;

    DelFlag(String value) {
        this.value = value;
    }

}
