package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbAcquisitionCenter;
import com.htht.business.app.dto.AppDbAcquisitionCenterDTO;
import com.htht.business.app.service.AppDbAcquisitionCenterService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

/**
 * 采集中心
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: AcquisitionCenterController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/28 14:24
 * @version: 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/acquisitionCenter")
@SaIgnore
public class AcquisitionCenterController {

    private final AppDbAcquisitionCenterService appDbAcquisitionCenterService;


    /**
     * 查询
     */
    @PostMapping("/list")
    @SaIgnore
    public TableDataInfo<AppDbAcquisitionCenter> list(@RequestBody AppDbAcquisitionCenterDTO appDbAcquisitionCenterDTO){
        return appDbAcquisitionCenterService.selectList(appDbAcquisitionCenterDTO);
    }

    /**
     * 新增
     */
    @PostMapping("/insert")
    @SaIgnore
    @Transactional
    public R<Object> insert(@RequestBody AppDbAcquisitionCenterDTO appDbAcquisitionCenterDTO) throws UnknownHostException {
        return R.ok(appDbAcquisitionCenterService.insert(appDbAcquisitionCenterDTO));
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @Transactional
    public R<Object> delete(Long id){
        try {
            appDbAcquisitionCenterService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.ok("删除失败，请联系管理员");
        }
    }

}
