package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbRawTeaStatistics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbRawTeaStatisticsDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbRawTeaStatisticsService extends IService<AppDbRawTeaStatistics> {

    TableDataInfo<AppDbRawTeaStatistics> selectList(AppDbRawTeaStatisticsDTO appDbRawTeaStatisticsDTO);
}
