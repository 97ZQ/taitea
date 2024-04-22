package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbTeaGrower;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbTeaGrowerService extends IService<AppDbTeaGrower> {

    TableDataInfo<AppDbTeaGrower> selectList(Long teaId, PageQuery pageQuery);
}
