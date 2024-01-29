package com.htht.business.thirty.request.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class DeviceSensor {

    /**
     * 所在区域
     */
    private Long areaId;

    /**
     * 传感器 ID
     */
    private Long sensorId;

    /**
     * 传感器名称
     */
    private String sensorName;

    /**
     * 数据类型
     */
    @JsonAlias("SensorType")
    private Integer sensorType;

    /**
     * 传感器数据列表
     */
    @JsonAlias("sensorData")
    private List<SensorData> sensorDataList;

}
