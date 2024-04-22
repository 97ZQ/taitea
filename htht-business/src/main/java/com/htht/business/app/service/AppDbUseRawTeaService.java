package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbUseRawTea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbUseRawTeaDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbUseRawTeaService extends IService<AppDbUseRawTea> {

    TableDataInfo<AppDbUseRawTea> selectList(AppDbUseRawTeaDTO appDbUseRawTeaDTO);
}
