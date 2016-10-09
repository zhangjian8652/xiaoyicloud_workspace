package com.joker.modules.management.exception;

/**
 * @Author zhangjian
 * @Date 2015/10/31
 */
public class SesionOperateException extends Exception {

    public SesionOperateException() {
    }

    public SesionOperateException(String message) {
        super(message);
    }

    public SesionOperateException(String message, Throwable cause) {
        super(message, cause);
    }
}
