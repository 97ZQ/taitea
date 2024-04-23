package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbTeaGrower;
import com.htht.business.app.service.AppDbTeaGrowerService;
import com.htht.business.app.mapper.AppDbTeaGrowerMapper;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbTeaGrowerServiceImpl extends ServiceImpl<AppDbTeaGrowerMapper, AppDbTeaGrower>
    implements AppDbTeaGrowerService{

    @Override
    public TableDataInfo<AppDbTeaGrower> selectList(Long teaId,String teaGrowerName, PageQuery pageQuery) {
        Page<AppDbTeaGrower> page = lambdaQuery()
            .like(StringUtils.isNotBlank(teaGrowerName), AppDbTeaGrower::getTeaGrowerName,teaGrowerName)
            .eq(AppDbTeaGrower::getTeaId, teaId)
            .page(pageQuery.build());
        return TableDataInfo.build(page);
    }
}




