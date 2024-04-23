package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.app.domain.AppDbTeaGrower;
import com.htht.business.app.service.AppDbTeaGrowerService;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**茶农列表
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: TeaGrowerController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/24 22:39
 * @version: 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/teaGrower")
public class TeaGrowerController {

    private final AppDbTeaGrowerService appDbTeaGrowerService;


//    @GetMapping("/teaGrowerList")
//    @SaIgnore
//    public TableDataInfo<AppDbTeaGrower> teaGrowerList(Long teaId, PageQuery pageQuery){
//        return appDbTeaGrowerService.selectList(teaId, pageQuery);
//    }

    /**
     * 查询茶农列表
     * @param teaId id
     * @param teaGrowerName 茶农姓名
     * @param pageQuery
     * @return
     */
    @GetMapping("/teaGrowerList")
    @SaIgnore
    public TableDataInfo<AppDbTeaGrower> teaGrowerList(Long teaId, String teaGrowerName, PageQuery pageQuery){
        return appDbTeaGrowerService.selectList(teaId,teaGrowerName, pageQuery);
    }

    /**
     * 新增茶农
     */
    @PostMapping("/insertGrower")
    @SaIgnore
    private R<Object> insertGrower(@RequestBody AppDbTeaGrower appDbTeaGrower){
        try {
            appDbTeaGrowerService.saveOrUpdate(appDbTeaGrower);
            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败，请联系管理员");
        }
    }
}
