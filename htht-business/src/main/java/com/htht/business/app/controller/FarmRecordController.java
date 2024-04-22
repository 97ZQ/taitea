package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.date.DateUtil;
import com.htht.business.app.domain.AppDbFarmRecord;
import com.htht.business.app.dto.AppDbFarmRecordDTO;
import com.htht.business.app.service.AppDbFarmRecordService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 农事记录
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: FarmRecordController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/25 17:53
 * @version: 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/farmRecord")
@SaIgnore
public class FarmRecordController {

    private final AppDbFarmRecordService appDbFarmRecordService;

    /**
     * 查询农事记录
     */
    @PostMapping("/selectFarmRecord")
    @SaIgnore
    public TableDataInfo<AppDbFarmRecord> selectFarmRecord(@RequestBody AppDbFarmRecordDTO appDbFarmRecordDTO){
        return appDbFarmRecordService.selectFarmRecord(appDbFarmRecordDTO);
    }

    /**
     * 新增或编辑农事记录
     */
    @PostMapping("/insertOrUpdateFarmRecord")
    @SaIgnore
    @Transactional
    public R<Object> insertOrUpdateFarmRecord(@RequestBody AppDbFarmRecord appDbFarmRecord){
        try {
            appDbFarmRecordService.saveOrUpdate(appDbFarmRecord);
            return R.ok("成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("失败,请联系管理员");
        }
    }

    /**
     * 根据id查看
     */
    @GetMapping("/selectById")
    @SaIgnore
    public AppDbFarmRecord selectById(Long id){
        return appDbFarmRecordService.getById(id);
    }

    /**
     * 根据id删除
     */
    @GetMapping("/deleteById")
    @SaIgnore
    @Transactional
    public R<Object> deleteById(Long id){
        try {
            appDbFarmRecordService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            return R.fail("删除失败，请联系管理员");
        }
    }
}
