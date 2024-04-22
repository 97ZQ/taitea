package com.htht.business.utils.vo;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.vo
 * @className: SevenDayWeatherDataVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/11 10:11
 * @version: 1.0
 */
@Data
public class SevenDayWeatherDataVo {
    /**
     * 日期
     */
    private String date;

    /**
     * 温度
     */
    private String temp;

    /**
     * 最高温度
     */
    private String maxTemp;

    /**
     * 最低温度
     */
    private String minTemp;

    /**
     *白天天气
     */
    private String dayWeather;

    /**
     * 夜间天气
     */
    private String nightWeather;
}
