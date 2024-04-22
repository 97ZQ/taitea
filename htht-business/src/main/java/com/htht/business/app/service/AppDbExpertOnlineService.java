package com.htht.business.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.domain.AppDbExpertOnline;
import com.htht.business.app.dto.AppDbExpertOnlineDTO;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.page.TableDataInfo;

/**
*
*/
public interface AppDbExpertOnlineService extends IService<AppDbExpertOnline> {

    TableDataInfo<AppDbExpertOnline> list(AppDbExpertOnlineDTO appDbExpertOnlineDTO);

    TableDataInfo<AppDbExpertOnline> userList();

    void reply(String replyContent, Long id);
}
