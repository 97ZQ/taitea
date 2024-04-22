package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbPolicyTeaStandard;
import com.htht.business.app.dto.AppDbPolicyTeaStandardDTO;
import com.htht.business.app.service.AppDbPolicyTeaStandardService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 泰山茶标准
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: PolicyTeaStandardController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 17:51
 * @version: 1.0
 */
@RestController
@RequestMapping("/policyTeaStandard")
@RequiredArgsConstructor
@SaIgnore
public class PolicyTeaStandardController {

    private final AppDbPolicyTeaStandardService appDbPolicyTeaStandardService;

    /**
     * 查询
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbPolicyTeaStandard> list(@RequestBody AppDbPolicyTeaStandardDTO appDbPolicyTeaStandardDTO){
        return appDbPolicyTeaStandardService.selectList(appDbPolicyTeaStandardDTO);
    }

    /**
     * 新增
     */
    @SaIgnore
    @PostMapping("/insert")
    @Transactional
    public R<Object> insert(@RequestBody AppDbPolicyTeaStandard appDbPolicyTeaStandard){
        try {
            appDbPolicyTeaStandard.setStaticPath("/static/" + appDbPolicyTeaStandard.getStaticPath());
            appDbPolicyTeaStandardService.save(appDbPolicyTeaStandard);
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
    public R<Object> update(@RequestBody AppDbPolicyTeaStandard appDbPolicyTeaStandard){
        try {
            appDbPolicyTeaStandardService.updateById(appDbPolicyTeaStandard);
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
       return R.ok(appDbPolicyTeaStandardService.getById(id));
    }

    /**
     * 根据id删除
     */
    @SaIgnore
    @Transactional
    @GetMapping("/delete")
    public R<Object> deleteById(Long id){
        try {
            appDbPolicyTeaStandardService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }
}
