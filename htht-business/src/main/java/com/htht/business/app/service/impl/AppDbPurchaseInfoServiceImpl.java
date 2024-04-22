package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbPurchaseInfo;
import com.htht.business.app.dto.AppDbPurchaseInfoDTO;
import com.htht.business.app.service.AppDbPriceInfoService;
import com.htht.business.app.service.AppDbPurchaseInfoService;
import com.htht.business.app.mapper.AppDbPurchaseInfoMapper;
import com.htht.common.helper.LoginHelper;
import com.htht.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AppDbPurchaseInfoServiceImpl extends ServiceImpl<AppDbPurchaseInfoMapper, AppDbPurchaseInfo>
    implements AppDbPurchaseInfoService{

    private final AppDbPriceInfoService appDbPriceInfoService;

    @Override
    public List<AppDbPurchaseInfo> selectList(AppDbPurchaseInfoDTO appDbPurchaseInfoDTO) {
        return this.lambdaQuery()
            .eq(StringUtils.isNotBlank(appDbPurchaseInfoDTO.getPurchaseInformation()), AppDbPurchaseInfo::getPurchaseInformation, appDbPurchaseInfoDTO.getPurchaseInformation())
            .list();
    }

    @Override
    public void publishPurchaseInfo(AppDbPurchaseInfo appDbPurchaseInfo) {
        this.saveOrUpdate(appDbPurchaseInfo);
    }
}




