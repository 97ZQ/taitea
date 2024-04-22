package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbFarmRecord;
import com.htht.business.app.domain.AppDbMyTeaGarden;
import com.htht.business.app.domain.AppDbResidenceApplicationForm;
import com.htht.business.app.service.AppDbFarmRecordService;
import com.htht.business.app.service.AppDbMyTeaGardenService;
import com.htht.business.app.mapper.AppDbMyTeaGardenMapper;
import com.htht.business.app.service.AppDbResidenceApplicationFormService;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.helper.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AppDbMyTeaGardenServiceImpl extends ServiceImpl<AppDbMyTeaGardenMapper, AppDbMyTeaGarden>
    implements AppDbMyTeaGardenService{

    private final AppDbResidenceApplicationFormService appDbResidenceApplicationFormService;

    @Override
    public List<AppDbMyTeaGarden> selectList() {
        Long userId = LoginHelper.getUserId();
        Long count = appDbResidenceApplicationFormService.lambdaQuery()
            .eq(AppDbResidenceApplicationForm::getChargePersonId, userId)
            .count();
        if (count != 0) {
            return this.lambdaQuery()
                .eq(AppDbMyTeaGarden::getTeaOwnerId, userId)
                .list();

        }
        return null;

    }
}




