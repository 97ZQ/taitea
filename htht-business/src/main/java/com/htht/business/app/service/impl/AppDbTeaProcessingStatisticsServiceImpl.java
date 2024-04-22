package com.htht.business.app.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbTeaProcessingStatistics;
import com.htht.business.app.dto.AppDbTeaProcessingStatisticsDTO;
import com.htht.business.app.service.AppDbTeaProcessingStatisticsService;
import com.htht.business.app.mapper.AppDbTeaProcessingStatisticsMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 */
@Service
public class AppDbTeaProcessingStatisticsServiceImpl extends ServiceImpl<AppDbTeaProcessingStatisticsMapper, AppDbTeaProcessingStatistics>
    implements AppDbTeaProcessingStatisticsService{

    @Override
    public TableDataInfo<AppDbTeaProcessingStatistics> teaProcessingStatistics(AppDbTeaProcessingStatisticsDTO appDbTeaProcessingStatisticsDTO) {
        Date dateTime = null;
        try{
            dateTime = appDbTeaProcessingStatisticsDTO.getProcessingDate();
        }catch (Exception e){
            e.printStackTrace();
        }
        Page<AppDbTeaProcessingStatistics> page = this.lambdaQuery()
            .eq(dateTime != null, AppDbTeaProcessingStatistics::getProcessingDate, appDbTeaProcessingStatisticsDTO.getProcessingDate())
            .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, appDbTeaProcessingStatisticsDTO.getTeaFactoryId())
            .eq(AppDbTeaProcessingStatistics::getTeaId, appDbTeaProcessingStatisticsDTO.getTeaId())
            .page(appDbTeaProcessingStatisticsDTO.build());
        return TableDataInfo.build(page);
    }
}




