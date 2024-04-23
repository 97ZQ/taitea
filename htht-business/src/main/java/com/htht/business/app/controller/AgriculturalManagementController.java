package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.date.DateUtil;
import com.htht.business.app.domain.*;
import com.htht.business.app.dto.AppDbTeaProcessingStatisticsDTO;
import com.htht.business.app.dto.MyTeaGardenOrMyTeaFactoryDTO;
import com.htht.business.app.service.*;
import com.htht.business.app.vo.MyTeaGardenAndTeaFactoryVo;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.helper.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 农事管理
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: AgriculturalManagementController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/24 17:18
 * @version: 1.0
 */
@RequestMapping("/agriculturalManagement")
@RestController
@RequiredArgsConstructor
@SaIgnore
public class AgriculturalManagementController {

    private final AppDbMyTeaFactoryService appDbMyTeaFactoryService;

    private final AppDbMyTeaGardenService appDbMyTeaGardenService;

    private final AppDbTeaProcessingStatisticsService appDbTeaProcessingStatisticsService;

    private final AppDbUseGreenTeaService appDbUseGreenTeaService;

    private final AppDbBrowishGreenStatisticsService appDbBrowishGreenStatisticsService;

    private final AppDbGreenTeaAllService appDbGreenTeaAllService;

    private final AppDbRawTeaStatisticsService appDbRawTeaStatisticsService;

    private final AppDbUseRawTeaService appDbUseRawTeaService;


    /**
     * 查询我的茶园和茶厂
     */
    @GetMapping("/selectMyTeaInfo")
//    @SaIgnore
    public R<MyTeaGardenAndTeaFactoryVo> selectMyTeaInfo(){
        MyTeaGardenAndTeaFactoryVo myTeaGardenAndTeaFactoryVo = new MyTeaGardenAndTeaFactoryVo();
        Long userId = LoginHelper.getUserId();
        List<AppDbMyTeaFactory> appDbMyTeaFactoryList = appDbMyTeaFactoryService.lambdaQuery()
            .eq(AppDbMyTeaFactory::getTeaFactoryChargeId, userId)
            .list();
        List<AppDbMyTeaGarden> appDbMyTeaGardenList = appDbMyTeaGardenService.lambdaQuery()
            .eq(AppDbMyTeaGarden::getTeaOwnerId, userId)
            .list();
        myTeaGardenAndTeaFactoryVo.setAppDbMyTeaFactoryList(appDbMyTeaFactoryList);
        myTeaGardenAndTeaFactoryVo.setAppDbMyTeaGardenList(appDbMyTeaGardenList);
        return R.ok(myTeaGardenAndTeaFactoryVo);
    }

    /**
     * 新增茶园/茶厂
     */
    @PostMapping("/insertTeaGardenOrTeaFactory")
//    @SaIgnore
    @Transactional
    public R<Object> insertTeaGardenOrTeaFactory(@RequestBody MyTeaGardenOrMyTeaFactoryDTO myTeaGardenOrMyTeaFactoryDTO){
        Integer identification = myTeaGardenOrMyTeaFactoryDTO.getIdentification();
        try {
            Long userId = LoginHelper.getUserId();
            if (identification == 1){
                AppDbMyTeaGarden appDbMyTeaGarden = new AppDbMyTeaGarden();
                appDbMyTeaGarden.setTeaName(myTeaGardenOrMyTeaFactoryDTO.getTeaName());
                appDbMyTeaGarden.setTeaIntroduce(myTeaGardenOrMyTeaFactoryDTO.getTeaIntroduce());
                appDbMyTeaGarden.setTeaOwnerId(userId);
                appDbMyTeaGardenService.saveOrUpdate(appDbMyTeaGarden);
            }else if (identification == 2){
                AppDbMyTeaFactory appDbMyTeaFactory = new AppDbMyTeaFactory();
                appDbMyTeaFactory.setTeaFactoryChargeId(userId);
                appDbMyTeaFactory.setTeaFactoryName(myTeaGardenOrMyTeaFactoryDTO.getTeaFactoryName());
                appDbMyTeaFactory.setTeaFactoryIntroduce(myTeaGardenOrMyTeaFactoryDTO.getTeaFactoryIntroduce());
                appDbMyTeaFactory.setTeaId(myTeaGardenOrMyTeaFactoryDTO.getTeaId());
                appDbMyTeaFactoryService.saveOrUpdate(appDbMyTeaFactory);
            }
            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败，请联系管理员");
        }
    }

    /**
     * 查询加工统计
     */
    @PostMapping("/teaProcessingStatistics")
//    @SaIgnore
    public TableDataInfo<AppDbTeaProcessingStatistics> teaProcessingStatistics(@RequestBody AppDbTeaProcessingStatisticsDTO appDbTeaProcessingStatisticsDTO){
        return appDbTeaProcessingStatisticsService.teaProcessingStatistics(appDbTeaProcessingStatisticsDTO);
    }

    /**
     * 根据id查询加工统计信息
     */
    @GetMapping("/getTeaInfoById")
//    @SaIgnore
    public AppDbTeaProcessingStatistics getTeaInfoById(Long id){
        return appDbTeaProcessingStatisticsService.getById(id);
    }

    /**
     * 新增或编辑加工统计
     */
    @PostMapping("/insertProcessingStatistics")
//    @SaIgnore
    @Transactional
    public R<Object> insertProcessingStatistics(@RequestBody AppDbTeaProcessingStatistics appDbTeaProcessingStatistics){
        try {
            //茶园id
            Long teaId = appDbTeaProcessingStatistics.getTeaId();
            //使用日期
            Date processingDate = appDbTeaProcessingStatistics.getProcessingDate();
            //茶厂id
            Long teaFactoryId = appDbTeaProcessingStatistics.getTeaFactoryId();
            //加工茶青等级
            Integer processingTeaLevel = appDbTeaProcessingStatistics.getProcessingTeaLevel();
            //使用茶青重量
            Double teaGreenWeight = appDbTeaProcessingStatistics.getTeaGreenWeight();
            //产出毛茶重量
            Double teaOutputQuantity = appDbTeaProcessingStatistics.getTeaOutputQuantity();
            //产出毛茶类型
            Integer teaOutputType = appDbTeaProcessingStatistics.getTeaOutputType();

            appDbTeaProcessingStatisticsService.saveOrUpdate(appDbTeaProcessingStatistics);

            //更新茶青使用记录表
            AppDbUseGreenTea appDbUseGreenTea = new AppDbUseGreenTea();
            appDbUseGreenTea.setTeaId(teaId);
            appDbUseGreenTea.setTeaFactoryId(teaFactoryId);
            appDbUseGreenTea.setUseTime(processingDate);
            if (processingTeaLevel == 0) {
                appDbUseGreenTea.setUseFirstLevelGreenTea(teaGreenWeight);
                appDbUseGreenTeaService.saveOrUpdate(appDbUseGreenTea);
            }else{
                appDbUseGreenTea.setUseSecondLevelGreenTea(teaGreenWeight);
                appDbUseGreenTeaService.saveOrUpdate(appDbUseGreenTea);
            }

            //更新茶青总量表
            //先查询历史总量再减去使用茶青总量

            //历史总量
            List<AppDbBrowishGreenStatistics> list = appDbBrowishGreenStatisticsService.lambdaQuery()
                .eq(AppDbBrowishGreenStatistics::getTeaGardenId, teaId)
                .list();
            if (processingTeaLevel == 0){
                //历史一级茶青总量
                double firstLevelGreenTea = list.stream()
                    .filter(statistics -> statistics.getFirstLevelAll() != null)
                    .mapToDouble(AppDbBrowishGreenStatistics::getFirstLevelAll).sum();
                //一级茶青使用总量
                List<AppDbUseGreenTea> firstLevel = appDbUseGreenTeaService.lambdaQuery()
                    .eq(AppDbUseGreenTea::getTeaFactoryId, teaFactoryId)
                    .eq(AppDbUseGreenTea::getTeaId, teaId)
                    .list();
                double firstLevelCount = firstLevel.stream()
                    .filter(statistics -> statistics.getUseFirstLevelGreenTea() != null)
                    .mapToDouble(AppDbUseGreenTea::getUseFirstLevelGreenTea).sum();
                double firstLevelFinalGreenTea;
                firstLevelFinalGreenTea = firstLevelGreenTea - firstLevelCount;

                Long count = appDbGreenTeaAllService.lambdaQuery()
                    .eq(AppDbGreenTeaAll::getTeaId, teaId)
                    .eq(AppDbGreenTeaAll::getTeaFactoryId, teaFactoryId)
                    .count();
                if (count == 0){
                    AppDbGreenTeaAll appDbGreenTeaAll = new AppDbGreenTeaAll();
                    appDbGreenTeaAll.setFirstLevelGreenTea(firstLevelFinalGreenTea);
                    appDbGreenTeaAll.setTeaFactoryId(teaFactoryId);
                    appDbGreenTeaAll.setTeaId(teaId);
                    appDbGreenTeaAllService.save(appDbGreenTeaAll);
                }else {
                    AppDbGreenTeaAll appDbGreenTeaAll = appDbGreenTeaAllService.lambdaQuery()
                        .eq(AppDbGreenTeaAll::getTeaId, teaId)
                        .eq(AppDbGreenTeaAll::getTeaFactoryId, teaFactoryId)
                        .one();
                    appDbGreenTeaAll.setFirstLevelGreenTea(firstLevelFinalGreenTea);
                    appDbGreenTeaAllService.saveOrUpdate(appDbGreenTeaAll);
                }
                //二级茶青总量
            }else {
                double secondLevelGreenTea = list.stream()
                    .filter(statistics -> statistics.getFirstLevelAll() != null)
                    .mapToDouble(AppDbBrowishGreenStatistics::getSecondLevelAll).sum();
                //二级茶青使用总量
                List<AppDbUseGreenTea> secondLevel = appDbUseGreenTeaService.lambdaQuery()
                    .eq(AppDbUseGreenTea::getTeaFactoryId, teaFactoryId)
                    .eq(AppDbUseGreenTea::getTeaId, teaId)
                    .list();
                double secondLevelCount = secondLevel.stream()
                    .filter(statistics -> statistics.getUseSecondLevelGreenTea() != null)
                    .mapToDouble(AppDbUseGreenTea::getUseSecondLevelGreenTea).sum();
                double secondLevelFinalGreenTea;
                secondLevelFinalGreenTea = secondLevelGreenTea - secondLevelCount;

                Long count = appDbGreenTeaAllService.lambdaQuery()
                    .eq(AppDbGreenTeaAll::getTeaId, teaId)
                    .eq(AppDbGreenTeaAll::getTeaFactoryId, teaFactoryId)
                    .count();
                if (count == 0){
                    AppDbGreenTeaAll appDbGreenTeaAll = new AppDbGreenTeaAll();
                    appDbGreenTeaAll.setFirstLevelGreenTea(secondLevelFinalGreenTea);
                    appDbGreenTeaAll.setTeaFactoryId(teaFactoryId);
                    appDbGreenTeaAll.setTeaId(teaId);
                    appDbGreenTeaAllService.save(appDbGreenTeaAll);
                }else {
                    AppDbGreenTeaAll appDbGreenTeaAll = appDbGreenTeaAllService.lambdaQuery()
                        .eq(AppDbGreenTeaAll::getTeaId, teaId)
                        .eq(AppDbGreenTeaAll::getTeaFactoryId, teaFactoryId)
                        .one();
                    appDbGreenTeaAll.setFirstLevelGreenTea(secondLevelFinalGreenTea);
                    appDbGreenTeaAllService.saveOrUpdate(appDbGreenTeaAll);
                }
            }
            //产出毛茶需要统计毛茶用量
            //使用茶园id和茶厂id筛选出所有毛茶产出量，然后统计起来再减去使用毛茶的数量，更新到总毛茶量里
            //查询出所有毛茶产出量
            //一级绿毛茶
            List<AppDbTeaProcessingStatistics> firstLevelGreenTea = appDbTeaProcessingStatisticsService.lambdaQuery()
                .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
                .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
                .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 0)
                .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 0)
                .list();
            double firstLevelGreenTeaCount = firstLevelGreenTea.stream()
                .filter(statistics -> statistics.getTeaOutputQuantity() != null)
                .mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

            //一级红毛茶
            List<AppDbTeaProcessingStatistics> firstLevelRedTea = appDbTeaProcessingStatisticsService.lambdaQuery()
                .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
                .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
                .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 0)
                .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 1)
                .list();
            double firstLevelRedTeaCount = firstLevelRedTea.stream()
                .filter(statistics -> statistics.getTeaOutputQuantity() != null)
                .mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

            //二级绿毛茶
            List<AppDbTeaProcessingStatistics> secondLevelGreenTea = appDbTeaProcessingStatisticsService.lambdaQuery()
                .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
                .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
                .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 1)
                .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 0)
                .list();
            double secondLevelGreenTeaCount = secondLevelGreenTea.stream()
                .filter(statistics -> statistics.getTeaOutputQuantity() != null)
                .mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

            //二级红毛茶
            List<AppDbTeaProcessingStatistics> secondLevelRedTea = appDbTeaProcessingStatisticsService.lambdaQuery()
                .eq(AppDbTeaProcessingStatistics::getTeaId, teaId)
                .eq(AppDbTeaProcessingStatistics::getTeaFactoryId, teaFactoryId)
                .eq(AppDbTeaProcessingStatistics::getProcessingTeaLevel, 1)
                .eq(AppDbTeaProcessingStatistics::getTeaOutputType, 1)
                .list();
            double secondLevelRedTeaCount = secondLevelRedTea.stream()
                .filter(statistics -> statistics.getTeaOutputQuantity() != null)
                .mapToDouble(AppDbTeaProcessingStatistics::getTeaOutputQuantity).sum();

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
            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败");
        }
    }
}
