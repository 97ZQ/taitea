package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.htht.business.app.domain.AppDbBrowishGreenStatistics;
import com.htht.business.app.dto.CreateDateDTO;
import com.htht.business.app.service.AppDbBrowishGreenStatisticsService;
import com.htht.business.app.vo.CreateDateVo;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 生成日期
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: CreateDateController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/28 11:31
 * @version: 1.0
 */
@RestController
@RequestMapping("/createDate")
@RequiredArgsConstructor
@SaIgnore
public class CreateDateController {

    private final AppDbBrowishGreenStatisticsService appDbBrowishGreenStatisticsService;



    /**
     * 补全日期，筛选数据
     */
    @PostMapping("/selectList")
    @SaIgnore
    public TableDataInfo<AppDbBrowishGreenStatistics> selectList(@RequestBody CreateDateDTO createDateDTO){
        return appDbBrowishGreenStatisticsService.createDate(createDateDTO);
    }

}
