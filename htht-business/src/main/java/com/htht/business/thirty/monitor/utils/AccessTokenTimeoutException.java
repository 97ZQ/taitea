package com.htht.business.thirty.monitor.utils;

public class AccessTokenTimeoutException extends RuntimeException {

    public AccessTokenTimeoutException() {
        super("accessToken过期");
    }
}
