package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbPurchaseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbPurchaseInfoDTO;

import java.util.List;

/**
 *
 */
public interface AppDbPurchaseInfoService extends IService<AppDbPurchaseInfo> {

    List<AppDbPurchaseInfo> selectList(AppDbPurchaseInfoDTO appDbPurchaseInfoDTO);

    void publishPurchaseInfo(AppDbPurchaseInfo appDbPurchaseInfo);
}
