package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbTeaProcessTechnology;
import com.htht.business.app.dto.AppDbTeaPlaneTechnologyDTO;
import com.htht.business.app.dto.AppDbTeaProcessTechnologyDTO;
import com.htht.business.app.service.AppDbTeaProcessTechnologyService;
import com.htht.business.app.mapper.AppDbTeaProcessTechnologyMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbTeaProcessTechnologyServiceImpl extends ServiceImpl<AppDbTeaProcessTechnologyMapper, AppDbTeaProcessTechnology>
    implements AppDbTeaProcessTechnologyService{

    @Override
    public TableDataInfo<AppDbTeaProcessTechnology> selectList(AppDbTeaProcessTechnologyDTO appDbTeaProcessTechnologyDTO) {
        IPage<AppDbTeaProcessTechnology> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbTeaProcessTechnologyDTO.getTitle()), AppDbTeaProcessTechnology::getTitle, appDbTeaProcessTechnologyDTO.getTitle())
            .page(appDbTeaProcessTechnologyDTO.build());
        return TableDataInfo.build(page);
    }
}




