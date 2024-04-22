package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbPolicyTeaStandard;
import com.htht.business.app.dto.AppDbPolicyTeaStandardDTO;
import com.htht.business.app.service.AppDbPolicyTeaStandardService;
import com.htht.business.app.mapper.AppDbPolicyTeaStandardMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbPolicyTeaStandardServiceImpl extends ServiceImpl<AppDbPolicyTeaStandardMapper, AppDbPolicyTeaStandard>
    implements AppDbPolicyTeaStandardService{

    @Override
    public TableDataInfo<AppDbPolicyTeaStandard> selectList(AppDbPolicyTeaStandardDTO appDbPolicyTeaStandardDTO) {
        Page<AppDbPolicyTeaStandard> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbPolicyTeaStandardDTO.getTitle()), AppDbPolicyTeaStandard::getTitle, appDbPolicyTeaStandardDTO.getTitle())
            .page(appDbPolicyTeaStandardDTO.build());
        return TableDataInfo.build(page);
    }
}




