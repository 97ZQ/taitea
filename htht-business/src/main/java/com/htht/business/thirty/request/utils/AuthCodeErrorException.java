package com.htht.business.thirty.request.utils;

public class AuthCodeErrorException extends RuntimeException {

    public AuthCodeErrorException() {
        super("authCode超时");
    }
}
