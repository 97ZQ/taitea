package com.htht.business.app.mapper;

import com.htht.business.app.domain.AppDbBrowishGreenStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.htht.business.app.domain.AppDbBrowishGreenStatistics
 */
public interface AppDbBrowishGreenStatisticsMapper extends BaseMapper<AppDbBrowishGreenStatistics> {

    List<AppDbBrowishGreenStatistics> getYearAndMonth(@Param("getYear") String getYear, @Param("getMonth") String getMonth, @Param("teaId") Long teaId);
}




