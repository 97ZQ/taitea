package com.htht.business.thirty.request.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SensorData {

    /**
     * 数据类型
     */
    @JsonAlias("DataType")
    private Integer dataType;

    /**
     * 数据名称
     */
    @JsonAlias("DataName")
    private String dataName;

    /**
     * 数据值
     */
    @JsonAlias("DataValue")
    private Double dataValue;

    /**
     * 单位
     */
    @JsonAlias("Unit")
    private String unit;

    /**
     * 数据上传时间
     */
    @JsonAlias("MonitorTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date monitorTime;

}
