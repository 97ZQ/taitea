package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbTeaPlaneTechnology;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbTeaPlaneTechnologyDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbTeaPlaneTechnologyService extends IService<AppDbTeaPlaneTechnology> {

    TableDataInfo<AppDbTeaPlaneTechnology> selectList(AppDbTeaPlaneTechnologyDTO appDbTeaPlaneTechnologyDTO);

    String insert(AppDbTeaPlaneTechnology appDbTeaPlaneTechnology);
}
