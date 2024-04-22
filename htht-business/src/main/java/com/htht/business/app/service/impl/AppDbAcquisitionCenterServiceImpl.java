package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbAcquisitionCenter;
import com.htht.business.app.dto.AppDbAcquisitionCenterDTO;
import com.htht.business.app.service.AppDbAcquisitionCenterService;
import com.htht.business.app.mapper.AppDbAcquisitionCenterMapper;
import com.htht.common.core.page.TableDataInfo;
import com.htht.system.domain.SysFile;
import com.htht.system.service.ISysFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AppDbAcquisitionCenterServiceImpl extends ServiceImpl<AppDbAcquisitionCenterMapper, AppDbAcquisitionCenter>
    implements AppDbAcquisitionCenterService{

    private final ISysFileService iSysFileService;

    @Value("${file.root-path}")
    private String path;

    @Override
    public TableDataInfo<AppDbAcquisitionCenter> selectList(AppDbAcquisitionCenterDTO appDbAcquisitionCenterDTO) {
        Page<AppDbAcquisitionCenter> page = this.lambdaQuery()
            .page(appDbAcquisitionCenterDTO.build());
        return TableDataInfo.build(page);
    }

    @Override
    public Object insert(AppDbAcquisitionCenterDTO appDbAcquisitionCenterDTO) throws UnknownHostException {
        AppDbAcquisitionCenter appDbAcquisitionCenter = new AppDbAcquisitionCenter();
        appDbAcquisitionCenter.setCaptureTitle(appDbAcquisitionCenterDTO.getCaptureTitle());
        appDbAcquisitionCenter.setAttachments(appDbAcquisitionCenterDTO.getAttachments());
        appDbAcquisitionCenter.setCutOffTime(appDbAcquisitionCenterDTO.getCutOffTime());
        appDbAcquisitionCenter.setQuantityPurchased(appDbAcquisitionCenterDTO.getQuantityPurchased());
        appDbAcquisitionCenter.setStaticPath("/static/" + appDbAcquisitionCenterDTO.getStaticPath());
        appDbAcquisitionCenter.setFileId(appDbAcquisitionCenterDTO.getFileId());
        this.saveOrUpdate(appDbAcquisitionCenter);
        return "新增成功";
    }
}




