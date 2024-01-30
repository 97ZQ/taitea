package com.htht.business.thirty.monitor.utils;

import lombok.Data;

/**
 * 播放地址
 */
@Data
public class VideoAddress {

    /**
     * 状态描述
     */
    private String id;

    /**
     * 直播地址
     */
    private String url;

    /**
     * 直播地址有效期。expireTime参数为空时该字段无效
     */
    private Long expireTime;

}
