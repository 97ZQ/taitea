package com.htht.business.app.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.business.app.domain.AppDbTeaPic;
import com.htht.business.app.dto.PicDTO;
import lombok.Data;

import java.util.List;

/**
 * @projectName: htht
 * @package: com.htht.business.app.vo
 * @className: AppDbMyTeaGardenVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/29 15:19
 * @version: 1.0
 */
@Data
public class AppDbMyTeaGardenVo {
    /**
     * id
     */
    private Long id;

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
     * 静态地址
     */
    private List<PicDTO> staticPathList;
}
