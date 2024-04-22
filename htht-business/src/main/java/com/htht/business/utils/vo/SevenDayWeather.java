package com.htht.business.utils.vo;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.vo
 * @className: SevenDayWeather
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/11 2:01
 * @version: 1.0
 */
@Data
public class SevenDayWeather {

    private String date;

    private String MaxTemp;

    private String MinTemp;

    private String rainFall;

    private String tuRangWD;

    private String tuRangSD;
}
