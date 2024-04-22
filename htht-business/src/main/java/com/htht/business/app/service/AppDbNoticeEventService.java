package com.htht.business.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.domain.AppDbNoticeEvent;
import com.htht.business.app.dto.AppDbNoticeEventDTO;
import com.htht.common.core.page.TableDataInfo;

/**
*
*/
public interface AppDbNoticeEventService extends IService<AppDbNoticeEvent> {

    TableDataInfo<AppDbNoticeEvent> selectList(AppDbNoticeEventDTO appDbNoticeEventDTO);
}
