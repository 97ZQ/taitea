package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbUseRawTea;
import com.htht.business.app.dto.AppDbUseRawTeaDTO;
import com.htht.business.app.service.AppDbUseRawTeaService;
import com.htht.business.app.mapper.AppDbUseRawTeaMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class AppDbUseRawTeaServiceImpl extends ServiceImpl<AppDbUseRawTeaMapper, AppDbUseRawTea>
    implements AppDbUseRawTeaService{

    @Override
    public TableDataInfo<AppDbUseRawTea> selectList(AppDbUseRawTeaDTO appDbUseRawTeaDTO) {
//        String useTime = "";
//        try {
//            useTime = appDbUseRawTeaDTO.getUseTime().toString();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        List<AppDbUseRawTea> list = lambdaQuery()
            .eq(appDbUseRawTeaDTO.getUseTime() != null, AppDbUseRawTea::getUseTime, appDbUseRawTeaDTO.getUseTime())
            .eq(AppDbUseRawTea::getTeaId, appDbUseRawTeaDTO.getTeaId())
            .eq(AppDbUseRawTea::getTeaFactoryId, appDbUseRawTeaDTO.getTeaFactoryId())
            .list();
        return TableDataInfo.build(list);
    }
}




