package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.dtflys.forest.annotation.Post;
import com.htht.business.app.domain.AppDbPurchaseInfo;
import com.htht.business.app.dto.AppDbPurchaseInfoDTO;
import com.htht.business.app.service.AppDbPurchaseInfoService;
import com.htht.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 农资求购信息
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: AppDbPurchaseInfoController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/4/8 17:21
 * @version: 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/purchaseInfo")
public class AppDbPurchaseInfoController {

    private final AppDbPurchaseInfoService appDbPurchaseInfoService;

    /**
     * 查询求购信息
     */
    @PostMapping("/selectPublishInfo")
    public R<Object> selectPublishInfo(@RequestBody AppDbPurchaseInfoDTO appDbPurchaseInfoDTO){
       return R.ok(appDbPurchaseInfoService.selectList(appDbPurchaseInfoDTO));
    }


    /**
     * 发布求购
     */
    @PostMapping("/publishPurchaseInfo")
    @Transactional
    public R<Object> publishPurchaseInfo(@RequestBody AppDbPurchaseInfo appDbPurchaseInfo){
        try {
            appDbPurchaseInfoService.publishPurchaseInfo(appDbPurchaseInfo);
            return R.ok("发布成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("发布失败，请联系管理员");
        }
    }
}
