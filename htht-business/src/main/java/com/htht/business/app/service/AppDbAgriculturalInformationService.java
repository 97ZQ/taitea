package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbAgriculturalInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbAgriculturalInfoDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbAgriculturalInformationService extends IService<AppDbAgriculturalInformation> {

    TableDataInfo<AppDbAgriculturalInformation> selectList(AppDbAgriculturalInfoDTO appDbAgriculturalInfoDTO);

    TableDataInfo<AppDbAgriculturalInformation> selectSupplierList(AppDbAgriculturalInfoDTO appDbAgriculturalInfoDTO);
}
