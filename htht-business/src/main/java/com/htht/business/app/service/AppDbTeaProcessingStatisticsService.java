package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbTeaProcessingStatistics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbTeaProcessingStatisticsDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbTeaProcessingStatisticsService extends IService<AppDbTeaProcessingStatistics> {

    TableDataInfo<AppDbTeaProcessingStatistics> teaProcessingStatistics(AppDbTeaProcessingStatisticsDTO appDbTeaProcessingStatisticsDTO);
}
