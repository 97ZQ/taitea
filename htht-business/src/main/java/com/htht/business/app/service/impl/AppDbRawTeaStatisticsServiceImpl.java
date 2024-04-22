package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbRawTeaStatistics;
import com.htht.business.app.dto.AppDbRawTeaStatisticsDTO;
import com.htht.business.app.service.AppDbRawTeaStatisticsService;
import com.htht.business.app.mapper.AppDbRawTeaStatisticsMapper;
import com.htht.common.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class AppDbRawTeaStatisticsServiceImpl extends ServiceImpl<AppDbRawTeaStatisticsMapper, AppDbRawTeaStatistics>
    implements AppDbRawTeaStatisticsService{

    @Override
    public TableDataInfo<AppDbRawTeaStatistics> selectList(AppDbRawTeaStatisticsDTO appDbRawTeaStatisticsDTO) {
        List<AppDbRawTeaStatistics> list = this.lambdaQuery()
            .eq(AppDbRawTeaStatistics::getTeaFactoryId, appDbRawTeaStatisticsDTO.getTeaFactoryId())
            .eq(AppDbRawTeaStatistics::getTeaId, appDbRawTeaStatisticsDTO.getTeaId())
            .list();
        return TableDataInfo.build(list);
    }
}




