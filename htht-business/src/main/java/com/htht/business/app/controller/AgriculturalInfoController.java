package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.dtflys.forest.annotation.Get;
import com.htht.business.app.domain.AppDbAgriculturalInformation;
import com.htht.business.app.dto.AppDbAgriculturalInfoDTO;
import com.htht.business.app.service.AppDbAgriculturalInformationService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.helper.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 农资供应商
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: AgriculturalInfoController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/8 10:29
 * @version: 1.0
 */
@SaIgnore
@RequestMapping("/agriculturalInfo")
@RestController
@RequiredArgsConstructor
public class AgriculturalInfoController {

    private final AppDbAgriculturalInformationService appDbAgriculturalInformationService;

    /**
     * 查询供应商列表
     * @return
     */
    @PostMapping("/list")
    public TableDataInfo<AppDbAgriculturalInformation> list(@RequestBody AppDbAgriculturalInfoDTO appDbAgriculturalInfoDTO){
        return appDbAgriculturalInformationService.selectList(appDbAgriculturalInfoDTO);
    }

    /**
     * 查询供应商审批
     */
    @PostMapping
    public TableDataInfo<AppDbAgriculturalInformation> selectSupplierList(@RequestBody AppDbAgriculturalInfoDTO appDbAgriculturalInfoDTO){
        return appDbAgriculturalInformationService.selectSupplierList(appDbAgriculturalInfoDTO);
    }

    /**
     * 新增
     */
    @PostMapping("/insert")
    @Transactional
    public R<Object> insert(@RequestBody AppDbAgriculturalInformation appDbAgriculturalInformation){
        try {
            Long userId = LoginHelper.getUserId();
            appDbAgriculturalInformation.setApplicantId(userId);
            List<AppDbAgriculturalInformation> list = appDbAgriculturalInformationService.lambdaQuery()
                .eq(AppDbAgriculturalInformation::getApplicantId, userId)
                .list();
            if (list.size() != 0) {
                Long id = list.get(0).getId();
                appDbAgriculturalInformation.setId(id);
                appDbAgriculturalInformationService.saveOrUpdate(appDbAgriculturalInformation);
            }else {
                appDbAgriculturalInformationService.saveOrUpdate(appDbAgriculturalInformation);
            }
            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败，请联系管理员");
        }
    }

    /**
     * 编辑
     */
    @PostMapping("/update")
    @Transactional
    public R<Object> update(@RequestBody AppDbAgriculturalInformation appDbAgriculturalInformation){
        try {
            appDbAgriculturalInformationService.updateById(appDbAgriculturalInformation);
            return R.ok("编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("编辑失败，请联系管理员");
        }
    }

    /**
     * 根据id查询
     */
    @GetMapping("/selectById")
    public R<Object> selectById(Long id){
        return R.ok(appDbAgriculturalInformationService.getById(id));
    }

    /**
     * 根据id删除
     */
    @GetMapping("/deleteById")
    @Transactional
    public R<Object> deleteById(Long id){
        try {
            appDbAgriculturalInformationService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }

    /**
     * 查询是否申请入驻
     */
    @GetMapping("/selectEnterInfo")
    public R<Object> selectEnterInfo(){
        Long userId = LoginHelper.getUserId();
        List<AppDbAgriculturalInformation> list = appDbAgriculturalInformationService.lambdaQuery()
            .eq(AppDbAgriculturalInformation::getApplicantId, userId)
            .ne(AppDbAgriculturalInformation::getStatus, 0)
            .list();
        if (list.size() == 0){
            return R.ok(0);
        }else {
            return R.ok(list.get(0).getStatus());
        }
    }

}
