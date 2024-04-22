package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbNoticeEvent;
import com.htht.business.app.dto.AppDbNoticeEventDTO;
import com.htht.business.app.service.AppDbNoticeEventService;
import com.htht.business.app.mapper.AppDbNoticeEventMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class AppDbNoticeEventServiceImpl extends ServiceImpl<AppDbNoticeEventMapper, AppDbNoticeEvent>
implements AppDbNoticeEventService{

    @Override
    public TableDataInfo<AppDbNoticeEvent> selectList(AppDbNoticeEventDTO appDbNoticeEventDTO) {
        Page<AppDbNoticeEvent> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbNoticeEventDTO.getNoticeTitle()), AppDbNoticeEvent::getNoticeTitle, appDbNoticeEventDTO.getNoticeTitle())
            .page(appDbNoticeEventDTO.build());
        return TableDataInfo.build(page);
    }
}
