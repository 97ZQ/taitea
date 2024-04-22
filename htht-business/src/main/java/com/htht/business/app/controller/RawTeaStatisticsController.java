package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbRawTeaStatistics;
import com.htht.business.app.domain.AppDbUseRawTea;
import com.htht.business.app.dto.AppDbRawTeaStatisticsDTO;
import com.htht.business.app.dto.AppDbUseRawTeaDTO;
import com.htht.business.app.service.AppDbRawTeaStatisticsService;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 毛茶库存总量
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: RawTeaStatisticsController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/27 1:59
 * @version: 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/rawTeaStatistics")
@SaIgnore
public class RawTeaStatisticsController {

    private final AppDbRawTeaStatisticsService appDbRawTeaStatisticsService;


    /**
     * 查询毛茶库存
     */
    @PostMapping("/list")
    @SaIgnore
    public TableDataInfo<AppDbRawTeaStatistics> list(@RequestBody AppDbRawTeaStatisticsDTO appDbRawTeaStatisticsDTO){
        return appDbRawTeaStatisticsService.selectList(appDbRawTeaStatisticsDTO);
    }

//    /**
//     * 毛茶加工库存使用纪律
//     */
//    @PostMapping("/useRawTeaInfo")
//    @SaIgnore
//    public TableDataInfo<AppDbUseRawTea> useRawTeaInfo(@RequestBody AppDbUseRawTeaDTO appDbUseRawTeaDTO){
//
//    }

}
