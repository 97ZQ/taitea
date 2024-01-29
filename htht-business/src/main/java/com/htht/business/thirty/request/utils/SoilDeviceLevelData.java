package com.htht.business.thirty.request.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class SoilDeviceLevelData {

    /**
     * 土壤层级深度，单位 cm
     */
    @JsonAlias("CM")
    private Integer cm;

    /**
     * 土壤温度，单位℃
     */
    @JsonAlias("Temp")
    private Double temp;

    /**
     * 土壤湿度，单位%
     */
    @JsonAlias("Humidity")
    private Double humidity;

    /**
     * 土壤电导率,单位 mS/cm
     */
    @JsonAlias("EC")
    private Double ec;

}
