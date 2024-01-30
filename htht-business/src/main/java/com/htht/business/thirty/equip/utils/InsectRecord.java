package com.htht.business.thirty.equip.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class InsectRecord {

    @JsonAlias("Id")
    private Long id;

    @JsonAlias("DeviceId")
    private Long deviceId;

    /**
     * 运行日期
     */
    @JsonAlias("SDate")
    private Date sDate;

    /**
     * 开始时间
     */
    @JsonAlias("StartTime")
    Date startTime;

    /**
     * 诱虫时长
     */
    @JsonAlias("LampTime")
    Date lampTime;

    /**
     * 加热时长
     */
    @JsonAlias("HeatTime")
    Date heatTime;

    /**
     * 拍照时间
     */
    @JsonAlias("CameraTime")
    Date cameraTime;

    /**
     * 仓位号
     */
    @JsonAlias("BoxNo")
    Integer boxNo;

    /**
     * 图像编号
     */
    @JsonAlias("ImgNo")
    String imgNo;

    /**
     * 虫情图像地址
     */
    @JsonAlias("ImgAddress")
    String imgAddress;

    /**
     * 虫子数量
     */
    @JsonAlias("InsectNum")
    String insectNum;

    /**
     * 虫情识别结果
     */
    @JsonAlias("DetectResult")
    Map<String, Object> detectResult;

}
