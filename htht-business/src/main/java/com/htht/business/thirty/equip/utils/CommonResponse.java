package com.htht.business.thirty.equip.utils;

import lombok.Data;

@Data
public class CommonResponse<T> {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 响应code
     */
    private Integer code;

    /**
     * 数据
     */
    private T data;

    /**
     * 信息
     */
    private String msg;

}
