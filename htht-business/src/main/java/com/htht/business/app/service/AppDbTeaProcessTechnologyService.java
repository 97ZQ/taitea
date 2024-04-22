package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbTeaProcessTechnology;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbTeaPlaneTechnologyDTO;
import com.htht.business.app.dto.AppDbTeaProcessTechnologyDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbTeaProcessTechnologyService extends IService<AppDbTeaProcessTechnology> {

    TableDataInfo<AppDbTeaProcessTechnology> selectList(AppDbTeaProcessTechnologyDTO appDbTeaProcessTechnologyDTO);
}
