package com.htht.business.utils.vo;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.utils.vo
 * @className: WeatherVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/21 16:29
 * @version: 1.0
 */
@Data
public class WeatherVo {
    private String condition;

    private String date;

    private String theDay;

    private String temperature;

    private String tempCondition;
}
