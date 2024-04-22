package com.htht.business.app.controller;

import com.dtflys.forest.annotation.Post;
import com.htht.business.app.domain.AppDbPriceInfo;
import com.htht.business.app.service.AppDbPriceInfoService;
import com.htht.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报价信息
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: AppDbPriceInfoController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/4/8 17:20
 * @version: 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/priceInfo")
public class AppDbPriceInfoController {

    private final AppDbPriceInfoService appDbPriceInfoService;

    /**
     * 立即报价
     */
    @PostMapping("/offerNow")
    @Transactional
    public R<Object> offerNow(AppDbPriceInfo appDbPriceInfo){
        try {
            appDbPriceInfoService.offerNow(appDbPriceInfo);
            return R.ok("报价成功");
        }catch (Exception e) {
            e.printStackTrace();
            return R.fail("报价失败，请联系管理员");
        }
    }
}
