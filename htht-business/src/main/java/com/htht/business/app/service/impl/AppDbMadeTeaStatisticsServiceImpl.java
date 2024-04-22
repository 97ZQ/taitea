package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbMadeTeaStatistics;
import com.htht.business.app.domain.AppDbRawTeaStatistics;
import com.htht.business.app.domain.AppDbTeaProcessingStatistics;
import com.htht.business.app.domain.AppDbUseRawTea;
import com.htht.business.app.dto.AppDbMadeTeaStatisticsDTO;
import com.htht.business.app.service.*;
import com.htht.business.app.mapper.AppDbMadeTeaStatisticsMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AppDbMadeTeaStatisticsServiceImpl extends ServiceImpl<AppDbMadeTeaStatisticsMapper, AppDbMadeTeaStatistics>
    implements AppDbMadeTeaStatisticsService{

    private final AppDbUseRawTeaService appDbUseRawTeaService;

    private final AppDbTeaProcessingStatisticsService appDbTeaProcessingStatisticsService;

    private final AppDbRawTeaStatisticsService appDbRawTeaStatisticsService;

    @Override
    public TableDataInfo<AppDbMadeTeaStatistics> finishedList(AppDbMadeTeaStatisticsDTO appDbMadeTeaStatisticsDTO) {
        List<AppDbMadeTeaStatistics> list = this.lambdaQuery()
            .eq(appDbMadeTeaStatisticsDTO.getFinishedTeaStatisticsDate() != null, AppDbMadeTeaStatistics::getFinishedTeaStatisticsDate, appDbMadeTeaStatisticsDTO.getFinishedTeaStatisticsDate())
            .eq(AppDbMadeTeaStatistics::getTeaFactoryId, appDbMadeTeaStatisticsDTO.getTeaFactoryId())
            .eq(AppDbMadeTeaStatistics::getTeaId, appDbMadeTeaStatisticsDTO.getTeaId())
            .list();
        return TableDataInfo.build(list);
    }

    @Override
    public void insertOrUpdate(AppDbMadeTeaStatistics appDbMadeTeaStatistics) {
        this.saveOrUpdate(appDbMadeTeaStatistics);
        //一级绿毛茶用量
        Double firstLevelGreenRawTea = appDbMadeTeaStatistics.getFirstLevelGreenRawTea();
        //二级绿毛茶用量
        Double secondLevelGreenRawTea = appDbMadeTeaStatistics.getSecondLevelGreenRawTea();
        //一级红毛茶用量
        Double firstLevelRedRawTea = appDbMadeTeaStatistics.getFirstLevelRedRawTea();
        //二级红毛茶用量
        Double secondLevelRedRawTea = appDbMadeTeaStatistics.getSecondLevelRedRawTea();
        //生产日期
        Date finishedTeaStatisticsDate = appDbMadeTeaStatistics.getFinishedTeaStatisticsDate();

        //获取毛茶用量后需要存入毛茶使用统计表
        AppDbUseRawTea appDbUseRawTea = new AppDbUseRawTea();
        appDbUseRawTea.setTeaFactoryId(appDbMadeTeaStatistics.getTeaFactoryId());
        appDbUseRawTea.setTeaId(appDbMadeTeaStatistics.getTeaId());
        appDbUseRawTea.setUseFirstLevelGreenRawTea(firstLevelGreenRawTea);
        appDbUseRawTea.setUseSecondLevelGreenRawTea(secondLevelGreenRawTea);
        appDbUseRawTea.setUseFirstLevelRedRawTea(firstLevelRedRawTea);
        appDbUseRawTea.setUseSecondLevelRedRawTea(secondLevelRedRawTea);
        appDbUseRawTea.setUseTime(finishedTeaStatisticsDate);
        appDbUseRawTeaService.saveOrUpdate(appDbUseRawTea);

        Long teaFactoryId = appDbMadeTeaStatistics.getTeaFactoryId();
        Long teaId = appDbMadeTeaStatistics.getTeaId();


        //查询毛茶总量
        //一级绿毛茶
        List<AppDbTeaProcessingStatistics> firstLevelGreenTea = appDbTeaProcessingStatisticsService.lambdaQuery()
            .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
            .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
            .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 0)
            .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 0)
            .list();
        double firstLevelGreenTeaCount = firstLevelGreenTea.stream().mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

        //一级红毛茶
        List<AppDbTeaProcessingStatistics> firstLevelRedTea = appDbTeaProcessingStatisticsService.lambdaQuery()
            .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
            .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
            .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 0)
            .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 1)
            .list();
        double firstLevelRedTeaCount = firstLevelRedTea.stream().mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

        //二级绿毛茶
        List<AppDbTeaProcessingStatistics> secondLevelGreenTea = appDbTeaProcessingStatisticsService.lambdaQuery()
            .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
            .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
            .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 1)
            .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 0)
            .list();
        double secondLevelGreenTeaCount = secondLevelGreenTea.stream().mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

        //二级红毛茶
        List<AppDbTeaProcessingStatistics> secondLevelRedTea = appDbTeaProcessingStatisticsService.lambdaQuery()
            .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
            .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
            .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 1)
            .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 1)
            .list();
        double secondLevelRedTeaCount = secondLevelRedTea.stream().mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

        //查出毛茶总量后在查询使用毛茶总量
        List<AppDbUseRawTea> appDbUseRawTeaList = appDbUseRawTeaService.lambdaQuery()
            .eq(AppDbUseRawTea::getTeaFactoryId, teaFactoryId)
            .eq(AppDbUseRawTea::getTeaId, teaId)
            .list();
        //一级绿毛茶使用量
        double useFirstLevelGreenRawTea = appDbUseRawTeaList.stream().mapToDouble(AppDbUseRawTea::getUseFirstLevelGreenRawTea).sum();
        //二级绿毛茶使用量
        double useSecondLevelGreenRawTea = appDbUseRawTeaList.stream().mapToDouble(AppDbUseRawTea::getUseSecondLevelGreenRawTea).sum();
        //一级红毛茶使用量
        double useFirstLevelRedRawTea = appDbUseRawTeaList.stream().mapToDouble(AppDbUseRawTea::getUseFirstLevelRedRawTea).sum();
        //二级红毛茶使用量
        double useSecondLevelRedRawTea = appDbUseRawTeaList.stream().mapToDouble(AppDbUseRawTea::getUseSecondLevelRedRawTea).sum();

        //一级绿毛茶总量
        double finalFirstLevelGreenRawTea = firstLevelGreenTeaCount - useFirstLevelGreenRawTea;
        //二级绿毛茶总量
        double finalSecondLevelGreenRawTea = secondLevelGreenTeaCount - useSecondLevelGreenRawTea;
        //一级红毛茶总量
        double finalFirstLevelRedRawTea = firstLevelRedTeaCount - useFirstLevelRedRawTea;
        //二级红毛茶总量
        double finalSecondLevelRedRawTea = secondLevelRedTeaCount - useSecondLevelRedRawTea;

        //统计完后存入毛茶总量表
        Long count = appDbRawTeaStatisticsService.lambdaQuery()
            .eq(AppDbRawTeaStatistics::getTeaFactoryId, teaFactoryId)
            .eq(AppDbRawTeaStatistics::getTeaId, teaId)
            .count();
        if (count == 0){
            AppDbRawTeaStatistics appDbRawTeaStatistics = new AppDbRawTeaStatistics();
            appDbRawTeaStatistics.setTeaFactoryId(teaFactoryId);
            appDbRawTeaStatistics.setTeaId(teaId);
            appDbRawTeaStatistics.setFirstLevelGreenRawTea(finalFirstLevelGreenRawTea);
            appDbRawTeaStatistics.setFirstLevelRedRawTea(finalFirstLevelRedRawTea);
            appDbRawTeaStatistics.setSecondLevelGreenRawTea(finalSecondLevelGreenRawTea);
            appDbRawTeaStatistics.setSecondLevelRedRawTea(finalSecondLevelRedRawTea);
            appDbRawTeaStatisticsService.saveOrUpdate(appDbRawTeaStatistics);
        }else {
            AppDbRawTeaStatistics rawTeaStatistics = appDbRawTeaStatisticsService.lambdaQuery()
                .eq(AppDbRawTeaStatistics::getTeaFactoryId, teaFactoryId)
                .eq(AppDbRawTeaStatistics::getTeaId, teaId)
                .one();
            rawTeaStatistics.setFirstLevelGreenRawTea(finalFirstLevelGreenRawTea);
            rawTeaStatistics.setFirstLevelRedRawTea(finalFirstLevelRedRawTea);
            rawTeaStatistics.setSecondLevelGreenRawTea(finalSecondLevelGreenRawTea);
            rawTeaStatistics.setSecondLevelRedRawTea(finalSecondLevelRedRawTea);
            appDbRawTeaStatisticsService.saveOrUpdate(rawTeaStatistics);
        }
    }
}




