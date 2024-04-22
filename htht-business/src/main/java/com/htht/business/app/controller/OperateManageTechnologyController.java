package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbOperateManageTechnology;
import com.htht.business.app.dto.AppDbOperateManageTechnologyDTO;
import com.htht.business.app.service.AppDbOperateManageTechnologyService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 经营与管理技术
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: OperateManageTechnologyController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 15:47
 * @version: 1.0
 */
@RestController
@RequestMapping("/operateManageTechnology")
@SaIgnore
@RequiredArgsConstructor
public class OperateManageTechnologyController {

    private final AppDbOperateManageTechnologyService appDbOperateManageTechnologyService;

    /**
     * 查询
     * @param appDbOperateManageTechnologyDTO
     * @return
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbOperateManageTechnology> list(@RequestBody AppDbOperateManageTechnologyDTO appDbOperateManageTechnologyDTO){
        return appDbOperateManageTechnologyService.selectList(appDbOperateManageTechnologyDTO);
    }

    /**
     * 新增
     */
    @SaIgnore
    @PostMapping("/insert")
    @Transactional
    public R<Object> insert(@RequestBody AppDbOperateManageTechnology appDbOperateManageTechnology){
        try {
            appDbOperateManageTechnology.setStaticPath("/static/" + appDbOperateManageTechnology.getStaticPath());
            appDbOperateManageTechnologyService.save(appDbOperateManageTechnology);
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
    public R<Object> update(@RequestBody AppDbOperateManageTechnology appDbOperateManageTechnology){
        try {
            appDbOperateManageTechnologyService.updateById(appDbOperateManageTechnology);
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
        return R.ok(appDbOperateManageTechnologyService.getById(id));
    }

    /**
     * 根据id删除
     */
    @SaIgnore
    @GetMapping("/delete")
    @Transactional
    public R<Object> deleteById(Long id){
        try {
            appDbOperateManageTechnologyService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }
}
