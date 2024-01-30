package com.htht.business.thirty.equip.utils;

public class AuthCodeErrorException extends RuntimeException {

    public AuthCodeErrorException() {
        super("authCode超时");
    }
}
