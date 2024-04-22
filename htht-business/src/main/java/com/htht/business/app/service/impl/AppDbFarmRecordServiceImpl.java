package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbFarmRecord;
import com.htht.business.app.dto.AppDbFarmRecordDTO;
import com.htht.business.app.service.AppDbFarmRecordService;
import com.htht.business.app.mapper.AppDbFarmRecordMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 */
@Service
public class AppDbFarmRecordServiceImpl extends ServiceImpl<AppDbFarmRecordMapper, AppDbFarmRecord>
    implements AppDbFarmRecordService{

    @Override
    public TableDataInfo<AppDbFarmRecord> selectFarmRecord(AppDbFarmRecordDTO appDbFarmRecordDTO) {
        String date =null;
        try {
            Date workDate = appDbFarmRecordDTO.getWorkDate();
            date = workDate.toString();
        }catch (Exception e){
            date = null;
        }
        Page<AppDbFarmRecord> page = this.lambdaQuery()
            .eq(StringUtils.isNotEmpty(date), AppDbFarmRecord::getWorkDate, appDbFarmRecordDTO.getWorkDate())
            .eq(AppDbFarmRecord::getTeaGardenId, appDbFarmRecordDTO.getTeaGardenId())
            .orderByAsc(AppDbFarmRecord::getWorkDate)
            .page(appDbFarmRecordDTO.build());
        return TableDataInfo.build(page);
    }
}




