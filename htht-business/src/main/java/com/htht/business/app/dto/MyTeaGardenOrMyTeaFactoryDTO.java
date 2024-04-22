package com.htht.business.app.dto;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: MyTeaGardenOrMyTeaFactory
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/24 17:29
 * @version: 1.0
 */
@Data
public class MyTeaGardenOrMyTeaFactoryDTO {
    /**
     * 1:茶园 2:茶厂
     */
    private Integer identification;

    /**
     * 茶园名称
     */
    private String teaName;

    /**
     * 茶园介绍
     */
    private String teaIntroduce;

    /**
     * 轮播图1
     */
    private String carouselMapOne;

    /**
     * 轮播图2
     */
    private String carouselMapTwo;

    /**
     * 茶园负责人id
     */
    private Long teaOwnerId;

    /**
     * 茶园负责人名称
     */
    private String teaOwnerName;

    /**
     * 天气预报街道
     */
    private String weatherStreet;

    /**
     * 视频监控
     */
    private String videoSurveillance;

    /**
     * 茶园负责人电话
     */
    private String teaOwnerPhone;

    /**
     * 茶厂负责人id
     */
    private Long teaFactoryChargeId;

    /**
     * 茶厂负责人名称
     */
    private String teaFactoryChargeName;

    /**
     * 茶厂负责人联系电话
     */
    private String teaFactoryChargePhone;

    /**
     * 茶厂名称
     */
    private String teaFactoryName;

    /**
     * 茶厂介绍
     */
    private String teaFactoryIntroduce;

    /**
     * 茶园id
     */
    private Long teaId;



}
