package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbMyTeaGarden;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.page.TableDataInfo;

import java.util.List;

/**
 *
 */
public interface AppDbMyTeaGardenService extends IService<AppDbMyTeaGarden> {

    List<AppDbMyTeaGarden> selectList();
}
