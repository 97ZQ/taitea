package com.htht.business.app.service;

import com.htht.business.app.domain.AppDbFarmRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htht.business.app.dto.AppDbFarmRecordDTO;
import com.htht.common.core.page.TableDataInfo;

/**
 *
 */
public interface AppDbFarmRecordService extends IService<AppDbFarmRecord> {

    TableDataInfo<AppDbFarmRecord> selectFarmRecord(AppDbFarmRecordDTO appDbFarmRecordDTO);
}
