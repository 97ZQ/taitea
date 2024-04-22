package com.htht.business.app.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbTeaPlaneTechnology;
import com.htht.business.app.dto.AppDbTeaPlaneTechnologyDTO;
import com.htht.business.app.service.AppDbTeaPlaneTechnologyService;
import com.htht.business.app.mapper.AppDbTeaPlaneTechnologyMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.utils.StringUtils;
import com.htht.system.domain.SysFile;
import com.htht.system.service.ISysFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AppDbTeaPlaneTechnologyServiceImpl extends ServiceImpl<AppDbTeaPlaneTechnologyMapper, AppDbTeaPlaneTechnology>
    implements AppDbTeaPlaneTechnologyService{

    private final ISysFileService iSysFileService;
    @Value("${file.root-path}")
    private String path;

    @Override
    public TableDataInfo<AppDbTeaPlaneTechnology> selectList(AppDbTeaPlaneTechnologyDTO appDbTeaPlaneTechnologyDTO) {
        Page<AppDbTeaPlaneTechnology> page = this.lambdaQuery()
            .like(StringUtils.isNotBlank(appDbTeaPlaneTechnologyDTO.getTitle()), AppDbTeaPlaneTechnology::getTitle, appDbTeaPlaneTechnologyDTO.getTitle())
            .page(appDbTeaPlaneTechnologyDTO.build());
        return TableDataInfo.build(page);
    }


    @Override
    public String insert(AppDbTeaPlaneTechnology appDbTeaPlaneTechnology) {
        appDbTeaPlaneTechnology.setStaticPath("/static/" + appDbTeaPlaneTechnology.getStaticPath());
        this.saveOrUpdate(appDbTeaPlaneTechnology);
        return "新增成功";
    }
}




