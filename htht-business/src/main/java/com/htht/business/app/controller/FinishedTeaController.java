package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.dtflys.forest.annotation.Get;
import com.htht.business.app.domain.AppDbMadeTeaStatistics;
import com.htht.business.app.dto.AppDbMadeTeaStatisticsDTO;
import com.htht.business.app.service.AppDbMadeTeaStatisticsService;
import com.htht.business.app.vo.AppDbFinishedTeaVo;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 成品茶生产统计
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: FinishedTea
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/26 16:48
 * @version: 1.0
 */
@RestController
@RequestMapping("/finishedTea")
@RequiredArgsConstructor
@SaIgnore
public class FinishedTeaController {

    private final AppDbMadeTeaStatisticsService appDbMadeTeaStatisticsService;

    /**
     * 查询成品茶
     */
    @PostMapping("/finishedTeaList")
//    @SaIgnore
    public TableDataInfo<AppDbMadeTeaStatistics> finishedList(@RequestBody AppDbMadeTeaStatisticsDTO appDbMadeTeaStatisticsDTO){
        return appDbMadeTeaStatisticsService.finishedList(appDbMadeTeaStatisticsDTO);
    }

    /**
     * 新增成品茶
     */
    @PostMapping("/insertOrUpdateFinishedTea")
//    @SaIgnore
    @Transactional
    public R<Object> insertOrUpdateFinishedTea(@RequestBody AppDbMadeTeaStatistics appDbMadeTeaStatistics){
        try {
            appDbMadeTeaStatisticsService.insertOrUpdate(appDbMadeTeaStatistics);
            return R.ok("成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("失败，请联系管理员");
        }
    }

    /**
     * 成品茶统计
     */
    @GetMapping("/finishedTeaCount")
//    @SaIgnore
    public R<Object> finishedTeaCount(Long teaFactoryId){
        List<AppDbMadeTeaStatistics> list = appDbMadeTeaStatisticsService.lambdaQuery()
            .eq(AppDbMadeTeaStatistics::getTeaFactoryId, teaFactoryId)
            .list();
        //一级绿茶
        int greenTeaFirstLevel = list.stream().mapToInt(AppDbMadeTeaStatistics::getGreenTeaFirstLevel).sum();
        //二级绿茶
        int greenTeaSecondLevel = list.stream().mapToInt(AppDbMadeTeaStatistics::getGreenTeaSecondLevel).sum();
        //一级红茶
        int redTeaFirstLevel = list.stream().mapToInt(AppDbMadeTeaStatistics::getRedTeaFirstLevel).sum();
        //二级红茶
        int redTeaSecondLevel = list.stream().mapToInt(AppDbMadeTeaStatistics::getRedTeaSecondLevel).sum();

        AppDbFinishedTeaVo appDbFinishedTeaVo = new AppDbFinishedTeaVo();

        appDbFinishedTeaVo.setGreenTeaFirstLevel(greenTeaFirstLevel);
        appDbFinishedTeaVo.setGreenTeaSecondLevel(greenTeaSecondLevel);
        appDbFinishedTeaVo.setRedTeaFirstLevel(redTeaFirstLevel);
        appDbFinishedTeaVo.setRedTeaSecondLevel(redTeaSecondLevel);

        return R.ok(appDbFinishedTeaVo);
    }

}
