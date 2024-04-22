package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbAgriculturalInformation;
import com.htht.business.app.dto.AppDbAgriculturalInfoDTO;
import com.htht.business.app.service.AppDbAgriculturalInformationService;
import com.htht.business.app.mapper.AppDbAgriculturalInformationMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbAgriculturalInformationServiceImpl extends ServiceImpl<AppDbAgriculturalInformationMapper, AppDbAgriculturalInformation>
    implements AppDbAgriculturalInformationService{

    @Override
    public TableDataInfo<AppDbAgriculturalInformation> selectList(AppDbAgriculturalInfoDTO appDbAgriculturalInfoDTO) {
        Page<AppDbAgriculturalInformation> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbAgriculturalInfoDTO.getMerchantName()), AppDbAgriculturalInformation::getMerchantName, appDbAgriculturalInfoDTO.getMerchantName())
            .like(StringUtils.isNotBlank(appDbAgriculturalInfoDTO.getMainBusiness()), AppDbAgriculturalInformation::getMainBusiness, appDbAgriculturalInfoDTO.getMainBusiness())
            .page(appDbAgriculturalInfoDTO.build());
        return TableDataInfo.build(page);
    }

    @Override
    public TableDataInfo<AppDbAgriculturalInformation> selectSupplierList(AppDbAgriculturalInfoDTO appDbAgriculturalInfoDTO) {
        Page<AppDbAgriculturalInformation> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbAgriculturalInfoDTO.getMerchantName()), AppDbAgriculturalInformation::getMerchantName, appDbAgriculturalInfoDTO.getMerchantName())
            .page(appDbAgriculturalInfoDTO.build());
        return TableDataInfo.build(page);
    }
}




