package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbTeaPlaneTechnology;
import com.htht.business.app.dto.AppDbTeaPlaneTechnologyDTO;
import com.htht.business.app.service.AppDbTeaPlaneTechnologyService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 茶叶种植技术
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: TeaPlaneTechnologyController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 14:37
 * @version: 1.0
 */
@SaIgnore
@RestController
@RequestMapping("/teaPlaneTechnology")
@RequiredArgsConstructor
public class TeaPlaneTechnologyController {

    private final AppDbTeaPlaneTechnologyService appDbTeaPlaneTechnologyService;

    /**
     * 查询
     * @param appDbTeaPlaneTechnologyDTO
     * @return
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbTeaPlaneTechnology> list(@RequestBody AppDbTeaPlaneTechnologyDTO appDbTeaPlaneTechnologyDTO){
        return appDbTeaPlaneTechnologyService.selectList(appDbTeaPlaneTechnologyDTO);
    }

    /**
     * 新增
     */
    @SaIgnore
    @PostMapping("/insert")
    @Transactional
    public R<Object> insert(@RequestBody AppDbTeaPlaneTechnology appDbTeaPlaneTechnology){
        try {
            appDbTeaPlaneTechnologyService.insert(appDbTeaPlaneTechnology);
//            appDbTeaPlaneTechnologyService.save(appDbTeaPlaneTechnology);
            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败，请联系管理员");
        }
    }

    /**
     * 编辑
     */
    @SaIgnore
    @PostMapping("/update")
    @Transactional
    public R<Object> update(@RequestBody AppDbTeaPlaneTechnology appDbTeaPlaneTechnology){
        try {
            appDbTeaPlaneTechnologyService.updateById(appDbTeaPlaneTechnology);
            return R.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("修改失败，请联系管理员");
        }
    }

    /**
     * 根据id查询
     */
    @SaIgnore
    @GetMapping("/selectById")
    public R<Object> selectById(Long id){
        return R.ok(appDbTeaPlaneTechnologyService.getById(id));
    }

    /**
     * 根据id删除
     */
    @SaIgnore
    @GetMapping("/deleteById")
    @Transactional
    public R<Object> deleteById(Long id){
        try {
            appDbTeaPlaneTechnologyService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }

}
