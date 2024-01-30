package com.htht.business.thirty.equip.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Device {

    /**
     *  设备 Id
     */
    @JsonAlias("Id")
    private Long id;

    /**
     * 农场id
     */
    @JsonAlias("FarmId")
    private Long farmId;

    /**
     * 设备名称
     */
    @JsonAlias("Name")
    private String name;

    /**
     * 设备编号
     */
    @JsonAlias("DisplayNo")
    private String displayNo;

    /**
     * 设备类型（6 为气象站）
     */
    @JsonAlias("DevType")
    private Integer devType;

    /**
     * 设备状态（0 不在线，1 在线）
     */
    @JsonAlias("Status")
    private Integer status;

}
