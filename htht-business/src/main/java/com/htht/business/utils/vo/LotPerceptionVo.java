package com.htht.business.utils.vo;

import lombok.Data;

/**
 * @projectName: citurs-orchard
 * @package: com.htht.business.vo
 * @className: LotPerceptionVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/1 11:09
 * @version: 1.0
 */
@Data
public class LotPerceptionVo {

    /**
     * 城市
     */
    private String cityName;
    /**
     * 温度
     */
    private String temperature;
    /**
     * 风向
     */
    private String windDirection;
    /**
     * 风速
     */
    private String windSpeed;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 空气质量指数
     */
    private String airQualityIndex;
    /**
     * 天气情况
     */
    private String weather;
    /**
     * 日期
     */
    private String date;
    /**
     * 土壤温度
     */
    private String tuRangWD;
    /**
     * 土壤湿度
     */
    private String tuRangSDString;
    /**
     * 土壤导电率
     */
    private String tuRangDD;
    /**
     * 环境湿度
     */
    private String environmentHumidity;
    /**
     * 环境温度
     */
    private String environmentTemperature;
    /**
     * 气压
     */
    private String pressure;
    /**
     *光照强度
     */
    private String illumination;
    /**
     * 叶面湿度
     */
    private String leafMoisture;;
    /**
     * 叶面温度
     */
    private String leafTemp;
}
