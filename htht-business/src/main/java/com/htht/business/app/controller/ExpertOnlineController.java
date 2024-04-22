package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbExpertOnline;
import com.htht.business.app.dto.AppDbExpertOnlineDTO;
import com.htht.business.app.service.AppDbExpertOnlineService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.helper.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 专家在线
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: ExpertOnlineController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/6 14:54
 * @version: 1.0
 */
@RestController
@RequestMapping("/expertOnline")
@SaIgnore
@RequiredArgsConstructor
public class ExpertOnlineController {

    private final AppDbExpertOnlineService appDbExpertOnlineService;

    /**
     * 查询
     * @param appDbExpertOnlineDTO
     * @return
     */
    @SaIgnore
    @PostMapping("/list")
    public TableDataInfo<AppDbExpertOnline> list(@RequestBody AppDbExpertOnlineDTO appDbExpertOnlineDTO){
        return appDbExpertOnlineService.list(appDbExpertOnlineDTO);
    }

    /**
     * 查询自己提问的问题
     * @return
     */
    @SaIgnore
    @GetMapping("/userList")
    public TableDataInfo<AppDbExpertOnline> userList(){
        return appDbExpertOnlineService.userList();
    }

    /**
     * 新增提问
     * @param appDbExpertOnline
     * @return
     */
    @SaIgnore
    @PostMapping("/insert")
    @Transactional
    public R<Object> insert(@RequestBody AppDbExpertOnline appDbExpertOnline){
        try {
            Long userId = LoginHelper.getUserId();
            appDbExpertOnline.setUserId(userId);
            appDbExpertOnlineService.saveOrUpdate(appDbExpertOnline);
            return R.ok("提交成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("提交失败,请联系管理员");
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @SaIgnore
    @GetMapping("/selectOne")
    public R<Object> selectOne(Long id){
        return R.ok(appDbExpertOnlineService.getById(id));
    }

    /**
     * 回复
     * @param replyContent
     * @param id
     * @return
     */
    @SaIgnore
    @GetMapping("/reply")
    public R<Object> reply(String replyContent, Long id){
        try{
            appDbExpertOnlineService.reply(replyContent, id);
            return R.ok("提交成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("提交失败,请联系管理员");
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @SaIgnore
    @GetMapping("/delete")
    @Transactional
    public R<Object> deleteById(Long id){
        try {
            appDbExpertOnlineService.getBaseMapper().deleteById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("删除失败，请联系管理员");
        }
    }
}
