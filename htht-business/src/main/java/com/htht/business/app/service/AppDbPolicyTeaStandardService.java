package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbPolicyTeaStandard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbPolicyTeaStandardDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbPolicyTeaStandardService extends IService<AppDbPolicyTeaStandard> {

    TableDataInfo<AppDbPolicyTeaStandard> selectList(AppDbPolicyTeaStandardDTO appDbPolicyTeaStandardDTO);
}
