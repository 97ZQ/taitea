package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbBrowishGreenPerson;
import com.htht.business.app.dto.AppDbBrowishGreenPersonDTO;
import com.htht.business.app.service.AppDbBrowishGreenPersonService;
import com.htht.business.app.mapper.AppDbBrowishGreenPersonMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbBrowishGreenPersonServiceImpl extends ServiceImpl<AppDbBrowishGreenPersonMapper, AppDbBrowishGreenPerson>
    implements AppDbBrowishGreenPersonService{

    @Override
    public TableDataInfo<AppDbBrowishGreenPerson> selectGreenPersonInfo(AppDbBrowishGreenPersonDTO appDbBrowishGreenPersonDTO) {
        Page<AppDbBrowishGreenPerson> page = lambdaQuery()
            .eq(AppDbBrowishGreenPerson::getBrowishGreenStatisticsId, appDbBrowishGreenPersonDTO.getBrowishGreenStatisticsId())
            .page(appDbBrowishGreenPersonDTO.build());
        return TableDataInfo.build(page);
    }
}




