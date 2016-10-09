package com.joker.modules.management.code;

/**
 * @Author zhangjian
 * @Date 2015/11/7
 */
public class ErrorCode {
    private String message;
    private String code;
    private String describe;

    public ErrorCode() {

    }

    public ErrorCode(String message, String code, String describe) {
        this.message = message;
        this.code = code;
        this.describe = describe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
