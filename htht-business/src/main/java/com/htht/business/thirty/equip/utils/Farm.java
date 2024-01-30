package com.htht.business.thirty.equip.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Farm {

    /**
     * 农场 Id
     */
    @JsonAlias("Id")
    private Long id;

    @JsonAlias("UserId")
    private Long userId;

    /**
     * 农场名称
     */
    @JsonAlias("Name")
    private String name;

    /**
     * 农场地址
     */
    @JsonAlias("Address")
    private String address;

    @JsonAlias("AdministrativeRegion")
    private String administrativeRegion;

    @JsonAlias("Remark")
    private String remark;

    @JsonAlias("CreateTime")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private String createTime;

    /**
     * 经纬度 用,分割
     */
    @JsonAlias("MapPoint")
    private String mapPoint;

    /**
     * 萤石云主账号
     */
    @JsonAlias("Ys7MaID")
    private String ys7MaID;

    /**
     * 萤石云子账号
     */
    @JsonAlias("Ys7SmID")
    private String ys7SmID;

    /**
     * 状态
     */
    @JsonAlias("Status")
    private Integer status;

    @JsonAlias("HistoryInterval")
    private Integer historyInterval;

}
