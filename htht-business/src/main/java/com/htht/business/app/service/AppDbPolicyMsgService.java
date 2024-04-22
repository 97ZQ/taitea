package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbPolicyMsg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbPolicyMsgDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbPolicyMsgService extends IService<AppDbPolicyMsg> {

    TableDataInfo<AppDbPolicyMsg> selectList(AppDbPolicyMsgDTO appDbPolicyMsgDTO);
}
