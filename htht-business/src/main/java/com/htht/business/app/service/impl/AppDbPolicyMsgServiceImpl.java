package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbPolicyMsg;
import com.htht.business.app.dto.AppDbPolicyMsgDTO;
import com.htht.business.app.service.AppDbPolicyMsgService;
import com.htht.business.app.mapper.AppDbPolicyMsgMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AppDbPolicyMsgServiceImpl extends ServiceImpl<AppDbPolicyMsgMapper, AppDbPolicyMsg>
    implements AppDbPolicyMsgService{

    @Override
    public TableDataInfo<AppDbPolicyMsg> selectList(AppDbPolicyMsgDTO appDbPolicyMsgDTO) {
        Page<AppDbPolicyMsg> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbPolicyMsgDTO.getTitle()), AppDbPolicyMsg::getTitle, appDbPolicyMsgDTO.getTitle())
            .page(appDbPolicyMsgDTO.build());
        return TableDataInfo.build(page);
    }
}




