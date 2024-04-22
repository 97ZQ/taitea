package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbBrowishGreenStatistics;
import com.htht.business.app.dto.AppDbBrowishGreenStatisticsDTO;
import com.htht.business.app.service.AppDbBrowishGreenStatisticsService;
import com.htht.business.app.vo.StatisticsGreenTeaVo;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 收青统计
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: BrowishGreenStatisticsController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/24 23:45
 * @version: 1.0
 */
@RequestMapping("/browishGreenStatistics")
@RestController
@RequiredArgsConstructor
@SaIgnore
public class BrowishGreenStatisticsController {

    private final AppDbBrowishGreenStatisticsService appDbBrowishGreenStatisticsService;

    /**
     * 查询收青统计
     */
    @PostMapping("/selectList")
    @SaIgnore
    public TableDataInfo<AppDbBrowishGreenStatistics> selectList(@RequestBody AppDbBrowishGreenStatisticsDTO appDbBrowishGreenStatisticsDTO){
        return appDbBrowishGreenStatisticsService.selectList(appDbBrowishGreenStatisticsDTO);
    }

//    /**
//     * 收青统计
//     */
//    @GetMapping("/count")
//    @SaIgnore
//    public R<Object> count(AppDbBrowishGreenStatisticsDTO appDbBrowishGreenStatisticsDTO){
//        return R.ok(appDbBrowishGreenStatisticsService.countTea(appDbBrowishGreenStatisticsDTO));
//    }

//    /**
//     * 统计所有一级二级茶青重量
//     */
//    @GetMapping("statisticsGreenTea")
//    @SaIgnore
//    public StatisticsGreenTeaVo statisticsGreenTea(Long teaId){
//
//    }
}
