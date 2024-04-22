package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbBrowishGreenPerson;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbBrowishGreenPersonDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbBrowishGreenPersonService extends IService<AppDbBrowishGreenPerson> {

    TableDataInfo<AppDbBrowishGreenPerson> selectGreenPersonInfo(AppDbBrowishGreenPersonDTO appDbBrowishGreenPersonDTO);
}
