package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbBrowishGreenStatistics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbBrowishGreenStatisticsDTO;
import com.htht.business.app.dto.CreateDateDTO;
import com.htht.business.app.vo.AppDbBrowishGreenStatisticsVo;
import com.htht.business.app.vo.CreateDateVo;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbBrowishGreenStatisticsService extends IService<AppDbBrowishGreenStatistics> {

    TableDataInfo<AppDbBrowishGreenStatistics> selectList(AppDbBrowishGreenStatisticsDTO appDbBrowishGreenStatisticsDTO);

    AppDbBrowishGreenStatisticsVo countTea(AppDbBrowishGreenStatisticsDTO appDbBrowishGreenStatisticsDTO);

    TableDataInfo<AppDbBrowishGreenStatistics> createDate(CreateDateDTO createDateDTO);
}
