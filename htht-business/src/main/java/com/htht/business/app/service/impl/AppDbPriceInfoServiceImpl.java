package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbPriceInfo;
import com.htht.business.app.service.AppDbPriceInfoService;
import com.htht.business.app.mapper.AppDbPriceInfoMapper;
import com.htht.common.helper.LoginHelper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbPriceInfoServiceImpl extends ServiceImpl<AppDbPriceInfoMapper, AppDbPriceInfo>
    implements AppDbPriceInfoService{

    @Override
    public void offerNow(AppDbPriceInfo appDbPriceInfo) {
        AppDbPriceInfo saveEntity = new AppDbPriceInfo();
        saveEntity.setContactPerson(appDbPriceInfo.getContactPerson());
        saveEntity.setContactPhone(appDbPriceInfo.getContactPhone());
        saveEntity.setFileUrl(appDbPriceInfo.getFileUrl());
        saveEntity.setPriceContent(appDbPriceInfo.getPriceContent());
        saveEntity.setPurchaseId(appDbPriceInfo.getPurchaseId());
        saveEntity.setPricePersonId(LoginHelper.getUserId());
        this.saveOrUpdate(saveEntity);
    }
}




