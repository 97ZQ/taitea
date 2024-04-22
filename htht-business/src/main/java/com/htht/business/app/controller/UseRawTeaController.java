package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbUseGreenTea;
import com.htht.business.app.domain.AppDbUseRawTea;
import com.htht.business.app.dto.AppDbUseRawTeaDTO;
import com.htht.business.app.service.AppDbUseRawTeaService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 毛茶使用量
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: UseRawTeaController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/27 2:07
 * @version: 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/useRawTea")
@SaIgnore
public class UseRawTeaController {

    private final AppDbUseRawTeaService appDbUseRawTeaService;

    /**
     * 查询毛茶使用记录
     */
    @PostMapping("/list")
    @SaIgnore
    public TableDataInfo<AppDbUseRawTea> list(@RequestBody AppDbUseRawTeaDTO appDbUseRawTeaDTO){
        return appDbUseRawTeaService.selectList(appDbUseRawTeaDTO);
    }
}
