package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.dtflys.forest.annotation.Get;
import com.htht.business.app.domain.AppDbResidenceApplicationForm;
import com.htht.business.app.service.AppDbResidenceApplicationFormService;
import com.htht.common.core.domain.R;
import com.htht.common.helper.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入驻申请
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: ResidenceApplicationFormController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/24 18:01
 * @version: 1.0
 */
@RequestMapping("/residenceApplicationForm")
@RestController
@RequiredArgsConstructor
public class ResidenceApplicationFormController {

    private final AppDbResidenceApplicationFormService appDbResidenceApplicationFormService;

    /**
     * 入驻申请
     */
    @PostMapping("/applicationForSettlement")
    @Transactional
    public R<Object> applicationForSettlement(@RequestBody AppDbResidenceApplicationForm appDbResidenceApplicationForm){
        Long userId = LoginHelper.getUserId();
        try {
            Long count = appDbResidenceApplicationFormService.lambdaQuery()
                .ne(AppDbResidenceApplicationForm::getStatus, 0)
                .eq(AppDbResidenceApplicationForm::getChargePersonId, userId)
                .count();
            Long userCount = appDbResidenceApplicationFormService.lambdaQuery()
                .eq(AppDbResidenceApplicationForm::getStatus, 3)
                .eq(AppDbResidenceApplicationForm::getChargePersonId, userId)
                .count();
            AppDbResidenceApplicationForm one = appDbResidenceApplicationFormService.lambdaQuery()
                .eq(AppDbResidenceApplicationForm::getChargePersonId, userId)
                .one();
            if (count == 0 || userCount != 0) {
                appDbResidenceApplicationForm.setChargePersonId(userId);
                appDbResidenceApplicationForm.setStatus(2);
                if (one.getId() != null){
                    appDbResidenceApplicationForm.setId(one.getId());
                }
                appDbResidenceApplicationFormService.saveOrUpdate(appDbResidenceApplicationForm);
                return R.ok("提交成功,请等待审批");
            }else {
                return R.fail("已申请入驻,请勿重复申请");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("提交失败，请联系管理员");
        }
    }

    /**
     * 入驻申请审批
     */
    @PostMapping("/enterTeaApprove")
    @Transactional
    public R<Object> enterTeaApprove(@RequestBody AppDbResidenceApplicationForm appDbResidenceApplicationForm){
        try {
            appDbResidenceApplicationFormService.saveOrUpdate(appDbResidenceApplicationForm);
            return R.ok("审批成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("审批失败，请联系管理员");
        }
    }

    /**
     * 查询是否申请入驻
     */
    @GetMapping("/selectEnterTeaRecord")
    public R<Object> selectEnterTeaRecord(){
        Long userId = LoginHelper.getUserId();
        List<AppDbResidenceApplicationForm> list = appDbResidenceApplicationFormService.lambdaQuery()
            .eq(AppDbResidenceApplicationForm::getChargePersonId, userId)
            .ne(AppDbResidenceApplicationForm::getStatus, 0)
            .list();
        if (list.size() == 0){
            return R.ok(0);
        }else {
            return R.ok(list.get(0).getStatus());
        }
    }

    /**
     * 查询入驻申请
     */
    @GetMapping("/getEnterTeaRecord")
    public R<Object> getEnterTeaRecord(){
        List<AppDbResidenceApplicationForm> list = appDbResidenceApplicationFormService.lambdaQuery()
            .list();
        return R.ok(list);
    }

}
