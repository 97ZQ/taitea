package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbMadeTeaStatistics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbMadeTeaStatisticsDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbMadeTeaStatisticsService extends IService<AppDbMadeTeaStatistics> {

    TableDataInfo<AppDbMadeTeaStatistics> finishedList(AppDbMadeTeaStatisticsDTO appDbMadeTeaStatisticsDTO);

    void insertOrUpdate(AppDbMadeTeaStatistics appDbMadeTeaStatistics);
}
