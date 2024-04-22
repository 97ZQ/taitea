package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbPolicyMsg;
import com.htht.business.app.dto.AppDbPolicyMsgDTO;
import com.htht.business.app.service.AppDbPolicyMsgService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 政策信息
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: PolicyMsgController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 16:34
 * @version: 1.0
 */
@SaIgnore
@RestController
@RequestMapping("/policyMsg")
@RequiredArgsConstructor
public class PolicyMsgController {

    private final AppDbPolicyMsgService appDbPolicyMsgService;

    /**
     *查询
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbPolicyMsg> list(@RequestBody AppDbPolicyMsgDTO appDbPolicyMsgDTO){
        return appDbPolicyMsgService.selectList(appDbPolicyMsgDTO);
    }

    /**
     * 新增
     */
    @SaIgnore
    @Transactional
    @PostMapping("/insert")
    public R<Object> insert(@RequestBody AppDbPolicyMsg appDbPolicyMsg){
        try {
            appDbPolicyMsg.setStaticPath("/static/" + appDbPolicyMsg.getStaticPath());
            appDbPolicyMsgService.save(appDbPolicyMsg);
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
    @Transactional
    @PostMapping("/update")
    public R<Object> update(@RequestBody AppDbPolicyMsg appDbPolicyMsg){
        try {
            appDbPolicyMsgService.updateById(appDbPolicyMsg);
            return R.ok("编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败，请联系管理员");
        }
    }

    /**
     * 根据id查询
     */
    @SaIgnore
    @GetMapping("/selectById")
    public R<Object> selectById(Long id){
        return R.ok(appDbPolicyMsgService.getById(id));
    }

    /**
     * 根据id删除
     */
    @SaIgnore
    @GetMapping("/delete")
    public R<Object> deleteById(Long id){
        try {
            appDbPolicyMsgService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }
}
