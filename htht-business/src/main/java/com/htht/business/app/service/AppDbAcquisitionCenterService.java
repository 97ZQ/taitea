package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbAcquisitionCenter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbAcquisitionCenterDTO;
import com.htht.common.core.page.TableDataInfo;

import java.net.UnknownHostException;

/**
 *
 */
public interface AppDbAcquisitionCenterService extends IService<AppDbAcquisitionCenter> {

    TableDataInfo<AppDbAcquisitionCenter> selectList(AppDbAcquisitionCenterDTO appDbAcquisitionCenterDTO);

    Object insert(AppDbAcquisitionCenterDTO appDbAcquisitionCenterDTO) throws UnknownHostException;
}
