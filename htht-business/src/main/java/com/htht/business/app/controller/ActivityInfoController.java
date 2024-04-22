package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbNoticeEvent;
import com.htht.business.app.dto.AppDbNoticeEventDTO;
import com.htht.business.app.service.AppDbNoticeEventService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 活动信息
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: ActivityInfoController
 * @author: zhangwei
 * @description: 活动信息
 * @date: 2024/3/7 10:15
 * @version: 1.0
 */
@RestController
@RequestMapping("/activityInfo")
@SaIgnore
@RequiredArgsConstructor
public class ActivityInfoController {

    private final AppDbNoticeEventService appDbNoticeEventService;

    /**
     * 查询
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbNoticeEvent> list(@RequestBody AppDbNoticeEventDTO appDbNoticeEventDTO){
        return appDbNoticeEventService.selectList(appDbNoticeEventDTO);
    }

    /**
     * 新增
     */
    @SaIgnore
    @Transactional
    @PostMapping("/insert")
    public R<Object> insert(@RequestBody AppDbNoticeEvent appDbNoticeEvent){
        try {
            appDbNoticeEventService.save(appDbNoticeEvent);
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
    public R<Object> update(@RequestBody AppDbNoticeEvent appDbNoticeEvent){
        try {
            appDbNoticeEventService.updateById(appDbNoticeEvent);
            return R.ok("编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("编辑失败,请联系管理员");
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @SaIgnore
    @Transactional
    @GetMapping("/selectById")
    public R<Object> selectById(Long id){
        return R.ok(appDbNoticeEventService.getById(id));
    }

    /**
     * 根据id删除
     */
    @SaIgnore
    @Transactional
    @GetMapping("/delete")
    public R<Object> delete(Long id){
        try{
            appDbNoticeEventService.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }
}
