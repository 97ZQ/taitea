package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbOperateManageTechnology;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbOperateManageTechnologyDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbOperateManageTechnologyService extends IService<AppDbOperateManageTechnology> {

    TableDataInfo<AppDbOperateManageTechnology> selectList(AppDbOperateManageTechnologyDTO appDbOperateManageTechnologyDTO);
}
