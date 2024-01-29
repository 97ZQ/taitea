package com.htht.business.thirty.request.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SoilDevice {

    /**
     * 设备 ID
     */
    @JsonAlias("DeviceId")
    private Long deviceId;

    /**
     * 数据上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonAlias("MonitorTime")
    private Date monitorTime;

    /**
     * 电量，单位%
     */
    @JsonAlias("Voltage")
    private Double voltage;

    /**
     * 表层温度，单位℃
     */
    @JsonAlias("SLT")
    private Double slt;

    /**
     * 土壤层级列表数据
     */
    @JsonAlias("Level")
    private List<SoilDeviceLevelData> soilDeviceLevelDataList;


}
