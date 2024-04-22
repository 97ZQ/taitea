package com.htht.business.utils.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @projectName: htht
 * @package: com.htht.business.utils.vo
 * @className: WeatherForecast
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/21 17:14
 * @version: 1.0
 */
public class WeatherForecast {
    private String date;
    private double temperature;
    private String weather;

    public WeatherForecast(String date, double temperature, String weather) {
        this.date = date;
        this.temperature = temperature;
        this.weather = weather;
    }

    public String getDate() {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeather() {
        return weather;
    }
}
