package com.htht.business.app.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import com.htht.business.app.service.AppDbBrowishGreenStatisticsService;
import com.htht.common.utils.file.FileUtils;
import jodd.io.FileUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ais数据定时存入动态表 （geoserver切片用）
 * @author dpf
 * @date 2023/7/14
 */
@Component
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "satellite", name = "flag", havingValue = "true")
public class SatelliteAutoScheduled {


    private final Date date = new Date();
    private DateTime dateTime = new DateTime(DateUtil.format(date,"yyyy-MM-dd")+" "+"00:00:00");

    private final AppDbBrowishGreenStatisticsService appDbBrowishGreenStatisticsService;

    @Scheduled(cron = "${satellite.cron}")
    public void importDataScheduled() throws IOException {

    }
}
