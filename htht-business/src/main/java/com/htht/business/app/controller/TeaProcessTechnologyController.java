package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbTeaProcessTechnology;
import com.htht.business.app.dto.AppDbTeaPlaneTechnologyDTO;
import com.htht.business.app.dto.AppDbTeaProcessTechnologyDTO;
import com.htht.business.app.service.AppDbTeaProcessTechnologyService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 茶叶加工技术
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: TeaProcessTechnologyController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 15:20
 * @version: 1.0
 */
@RestController
@RequestMapping("/teaProcessTechnology")
@RequiredArgsConstructor
@SaIgnore
public class TeaProcessTechnologyController {

    private final AppDbTeaProcessTechnologyService appDbTeaProcessTechnologyService;

    /**
     * 查询
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbTeaProcessTechnology> list(@RequestBody AppDbTeaProcessTechnologyDTO appDbTeaProcessTechnologyDTO){
        return appDbTeaProcessTechnologyService.selectList(appDbTeaProcessTechnologyDTO);
    }

    /**
     * 新增
     */
    @SaIgnore
    @Transactional
    @PostMapping("/insert")
    public R<Object> insert(@RequestBody AppDbTeaProcessTechnology appDbTeaProcessTechnology){
        try {
            appDbTeaProcessTechnology.setStaticPath("/static/" + appDbTeaProcessTechnology.getStaticPath());
            appDbTeaProcessTechnologyService.save(appDbTeaProcessTechnology);
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
    public R<Object> update(@RequestBody AppDbTeaProcessTechnology appDbTeaProcessTechnology){
        try{
            appDbTeaProcessTechnologyService.updateById(appDbTeaProcessTechnology);
            return R.ok("编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("编辑失败，请联系管理员");
        }
    }

    /**
     * 根据id查询
     */
    @SaIgnore
    @GetMapping("/selectById")
    public R<Object> selectById(Long id){
        return R.ok(appDbTeaProcessTechnologyService.getById(id));
    }

    /**
     * 根据id删除
     */
    @SaIgnore
    @GetMapping("/deleteById")
    @Transactional
    public R<Object> deleteById(Long id){
        try {
            appDbTeaProcessTechnologyService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }
}
