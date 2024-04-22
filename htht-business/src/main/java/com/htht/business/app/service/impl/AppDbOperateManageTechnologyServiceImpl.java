package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbOperateManageTechnology;
import com.htht.business.app.dto.AppDbOperateManageTechnologyDTO;
import com.htht.business.app.service.AppDbOperateManageTechnologyService;
import com.htht.business.app.mapper.AppDbOperateManageTechnologyMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbOperateManageTechnologyServiceImpl extends ServiceImpl<AppDbOperateManageTechnologyMapper, AppDbOperateManageTechnology>
    implements AppDbOperateManageTechnologyService{

    @Override
    public TableDataInfo<AppDbOperateManageTechnology> selectList(AppDbOperateManageTechnologyDTO appDbOperateManageTechnologyDTO) {
        Page<AppDbOperateManageTechnology> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbOperateManageTechnologyDTO.getTitle()), AppDbOperateManageTechnology::getTitle, appDbOperateManageTechnologyDTO.getTitle())
            .page(appDbOperateManageTechnologyDTO.build());
        return TableDataInfo.build(page);
    }
}




