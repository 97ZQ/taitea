package com.htht.business.source.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.source.domain.Source;
import com.htht.business.source.service.ISourceService;
import com.htht.business.source.service.dto.SourcePageDto;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 溯源
 */
@SaIgnore
@RestController
@RequestMapping("/source")
@RequiredArgsConstructor
public class SourceController {

    private final ISourceService iSourceService;

    /**
     * 新增
     *
     * @param source 实体
     */
    @PostMapping("/add")
    public R add(@RequestBody Source source) {
        iSourceService.add(source);
        return R.ok();
    }

    /**
     * 根据id更新
     *
     * @param source 实体
     */
    @PutMapping("/upd")
    public R upd(@RequestBody Source source) {
        iSourceService.upd(source);
        return R.ok();
    }

    /**
     * 根据id删除
     *
     * @param sourceId id
     */
    @DeleteMapping("/del")
    public R del(String sourceId) {
        iSourceService.del(sourceId);
        return R.ok();
    }

    /**
     * 根据分页查询条件查询数据
     *
     * @param sourcePageDto 分页查询实体
     */
    @GetMapping("/page")
    public R<TableDataInfo<Source>> page(SourcePageDto sourcePageDto) {
        return R.ok(iSourceService.page(sourcePageDto));
    }

    /**
     * 根据id获取数据
     *
     * @param sourceId id
     */
    @GetMapping("/getById")
    public R<Source> getById(String sourceId) {
        return R.ok(iSourceService.getById(sourceId));
    }

    /**
     * 根据溯源码获取数据
     *
     * @param code 溯源码
     */
    @GetMapping("/getByCode")
    public R<Source> getByCode(String code) {
        return R.ok(iSourceService.getByCode(code));
    }

    /**
     * 根据id生成二维码字节响应
     *
     * @param content  二维码内容
     * @param response 响应（前端忽略）
     */
    @GetMapping("/createQrCode")
    public void createQrCode(String content, HttpServletResponse response) {
        iSourceService.createQrCode(response, content);
    }

}
