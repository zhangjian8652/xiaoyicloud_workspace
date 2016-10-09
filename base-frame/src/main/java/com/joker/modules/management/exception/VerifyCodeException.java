package com.joker.modules.management.exception;

/**
 * @Author zhangjian
 * @Date 2015/11/7
 */
public class VerifyCodeException extends Exception {
    public VerifyCodeException() {
    }

    public VerifyCodeException(String message) {
        super(message);
    }

    public VerifyCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifyCodeException(Throwable cause) {
        super(cause);
    }

    public VerifyCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
