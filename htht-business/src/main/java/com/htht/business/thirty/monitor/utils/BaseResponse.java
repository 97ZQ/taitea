package com.htht.business.thirty.monitor.utils;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private String code;

    private String msg;

    private T data;

}
