package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.File;
import java.util.List;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbMyTeaGardenDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/26 16:39
 * @version: 1.0
 */
@Data
public class AppDbMyTeaGardenDTO {
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
    private File carouselMapOne;

    /**
     * 轮播图2
     */
    private File carouselMapTwo;

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
     * 静态文件List
     */
    private List<PicDTO> staticPathList;

    /**
     * 文件id
     */
    private List<Long> fileId;
}
