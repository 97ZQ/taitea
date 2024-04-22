package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbPriceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface AppDbPriceInfoService extends IService<AppDbPriceInfo> {

    void offerNow(AppDbPriceInfo appDbPriceInfo);
}
