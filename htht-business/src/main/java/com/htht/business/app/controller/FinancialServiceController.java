package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.service.AppDbFinancialServiceService;
import com.htht.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 金融服务
 */
@SaIgnore
@RestController
@RequestMapping("/financialService")
@RequiredArgsConstructor
public class FinancialServiceController {

    private final AppDbFinancialServiceService appDbFinancialServiceService;

    /**
     * 图片上传
     */
    @SaIgnore
    @GetMapping("uploadPic")
    private R<Object> picUpload(){
        return R.ok();
    }
}
