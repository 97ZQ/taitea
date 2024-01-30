package com.htht.business.thirty.monitor.utils;

import lombok.Data;

@Data
public class AccessTokenInfo {

    /**
     * accessToke
     */
    private String accessToken;

    /**
     * 过期时间。7天过期
     */
    private Long expireTime;

}
