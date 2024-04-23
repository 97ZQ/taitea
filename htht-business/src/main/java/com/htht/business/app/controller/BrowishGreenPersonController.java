package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.dtflys.forest.annotation.Post;
import com.htht.business.app.domain.AppDbAllGreenTeaStatistics;
import com.htht.business.app.domain.AppDbBrowishGreenPerson;
import com.htht.business.app.domain.AppDbBrowishGreenStatistics;
import com.htht.business.app.domain.AppDbUseGreenTea;
import com.htht.business.app.dto.AppDbBrowishGreenPersonDTO;
import com.htht.business.app.dto.InsertBrowishGreenPersonDTO;
import com.htht.business.app.service.AppDbAllGreenTeaStatisticsService;
import com.htht.business.app.service.AppDbBrowishGreenPersonService;
import com.htht.business.app.service.AppDbBrowishGreenStatisticsService;
import com.htht.business.app.service.AppDbUseGreenTeaService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 收青人员
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: BrowishGreenPersonController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/25 0:33
 * @version: 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/browishGreenPerson")
@SaIgnore
public class BrowishGreenPersonController {

    private final AppDbBrowishGreenPersonService appDbBrowishGreenPersonService;

    private final AppDbBrowishGreenStatisticsService appDbBrowishGreenStatisticsService;

    private final AppDbAllGreenTeaStatisticsService appDbAllGreenTeaStatisticsService;

    private final AppDbUseGreenTeaService appDbUseGreenTeaService;

    /**
     * 收青人员信息
     */
    @PostMapping("/browishGreenPersonInfo")
    @SaIgnore
    public TableDataInfo<AppDbBrowishGreenPerson> browishGreenPersonInfo(@RequestBody AppDbBrowishGreenPersonDTO appDbBrowishGreenPersonDTO){
        return appDbBrowishGreenPersonService.selectGreenPersonInfo(appDbBrowishGreenPersonDTO);
    }

    /**
     * 根据id查询收青人员信息
     */
    @GetMapping("/getById")
    @SaIgnore
    public R<Object> getById(Long id){
        return R.ok(appDbBrowishGreenPersonService.getById(id));
    }

    /**
     * 修改收青人员信息
     */
    @PostMapping("/updateBrowishGreenPersonInfo")
    @SaIgnore
    @Transactional
    public R<Object> updateBrowishGreenPersonInfo(@RequestBody InsertBrowishGreenPersonDTO insertBrowishGreenPersonDTO){
        try {
            AppDbBrowishGreenPerson appDbBrowishGreenPerson = new AppDbBrowishGreenPerson();
            List<AppDbBrowishGreenPerson> appDbBrowishGreenPersonList = insertBrowishGreenPersonDTO.getAppDbBrowishGreenPersonList();
            AppDbBrowishGreenPerson appDbBrowishGreenPerson1 = appDbBrowishGreenPersonList.get(0);

            appDbBrowishGreenPerson.setBrowishGreenStatisticsId(appDbBrowishGreenPerson1.getBrowishGreenStatisticsId());
            appDbBrowishGreenPerson.setBrowishGreenStatisticsDate(appDbBrowishGreenPerson1.getBrowishGreenStatisticsDate());
            appDbBrowishGreenPerson.setTeaId(appDbBrowishGreenPerson1.getTeaId());
            appDbBrowishGreenPerson.setBrowishGreenFirstLevel(appDbBrowishGreenPerson1.getBrowishGreenFirstLevel());
            appDbBrowishGreenPerson.setBrowishGreenFirstPrice(appDbBrowishGreenPerson1.getBrowishGreenFirstPrice());
            appDbBrowishGreenPerson.setBrowishGreenSecondLevel(appDbBrowishGreenPerson1.getBrowishGreenSecondLevel());
            appDbBrowishGreenPerson.setBrowishGreenSecondPrice(appDbBrowishGreenPerson1.getBrowishGreenSecondPrice());
            appDbBrowishGreenPerson.setTeaFarmerId(appDbBrowishGreenPerson1.getTeaFarmerId());
            appDbBrowishGreenPerson.setBrowishGreenStatisticsName(appDbBrowishGreenPerson1.getBrowishGreenStatisticsName());
            appDbBrowishGreenPerson.setId(appDbBrowishGreenPerson1.getId());
            appDbBrowishGreenPersonService.saveOrUpdate(appDbBrowishGreenPerson);
            Long browishGreenStatisticsId = appDbBrowishGreenPerson.getBrowishGreenStatisticsId();
            //获取当天收青总数
            List<AppDbBrowishGreenPerson> list1 = appDbBrowishGreenPersonService.lambdaQuery()
                .eq(AppDbBrowishGreenPerson::getBrowishGreenStatisticsId, browishGreenStatisticsId)
                .list();
            double finalFirstLevel = list1.stream().mapToDouble(AppDbBrowishGreenPerson::getBrowishGreenFirstLevel).sum();
            double finalSecondLevel = list1.stream().mapToDouble(AppDbBrowishGreenPerson::getBrowishGreenSecondLevel).sum();

            appDbBrowishGreenStatisticsService.lambdaUpdate()
                .set(AppDbBrowishGreenStatistics::getFirstLevelAll, finalFirstLevel)
                .set(AppDbBrowishGreenStatistics::getSecondLevelAll, finalSecondLevel)
                .eq(AppDbBrowishGreenStatistics::getId, browishGreenStatisticsId)
                .update();

            List<AppDbBrowishGreenStatistics> list = appDbBrowishGreenStatisticsService.lambdaQuery()
                .eq(AppDbBrowishGreenStatistics::getTeaGardenId, insertBrowishGreenPersonDTO.getTeaId())
                .list();
            double firstGreenTea = list.stream().mapToDouble(AppDbBrowishGreenStatistics::getFirstLevelAll).sum();
            double secondGreenTea = list.stream().mapToDouble(AppDbBrowishGreenStatistics::getSecondLevelAll).sum();
            Long count = appDbAllGreenTeaStatisticsService.lambdaQuery()
                .eq(AppDbAllGreenTeaStatistics::getTeaId, insertBrowishGreenPersonDTO.getTeaId())
                .count();
            if (count != 0) {
                appDbAllGreenTeaStatisticsService.lambdaUpdate()
                    .set(AppDbAllGreenTeaStatistics::getFirstLevelGreenTea, firstGreenTea)
                    .set(AppDbAllGreenTeaStatistics::getSecondLevelGreenTea, secondGreenTea)
                    .eq(AppDbAllGreenTeaStatistics::getTeaId, insertBrowishGreenPersonDTO.getTeaId())
                    .update();
            }else {
                AppDbAllGreenTeaStatistics appDbAllGreenTeaStatistics = new AppDbAllGreenTeaStatistics();
                appDbAllGreenTeaStatistics.setFirstLevelGreenTea(firstGreenTea);
                appDbAllGreenTeaStatistics.setSecondLevelGreenTea(secondGreenTea);
                appDbAllGreenTeaStatistics.setTeaId(insertBrowishGreenPersonDTO.getTeaId());
                appDbAllGreenTeaStatisticsService.saveOrUpdate(appDbAllGreenTeaStatistics);
            }


            return R.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("修改失败，请联系管理员");
        }
    }

    /**
     *新增收青
     */
    @PostMapping("/insertBrowishGreenPerson")
    @SaIgnore
    @Transactional
    public R<Object> insertBrowishGreenPerson(@RequestBody InsertBrowishGreenPersonDTO insertBrowishGreenPersonDTO){
        try {
            Long teaId = insertBrowishGreenPersonDTO.getTeaId();
            Date date = insertBrowishGreenPersonDTO.getDate();
            Long browishGreenStatisticsId = insertBrowishGreenPersonDTO.getBrowishGreenStatisticsId();
            List<AppDbBrowishGreenPerson> appDbBrowishGreenPersonList = insertBrowishGreenPersonDTO.getAppDbBrowishGreenPersonList();
            AppDbBrowishGreenStatistics appDbBrowishGreenStatistics = new AppDbBrowishGreenStatistics();


            appDbBrowishGreenStatistics.setTeaGardenId(teaId);
            appDbBrowishGreenStatistics.setTime(date);
            appDbBrowishGreenStatistics.setId(browishGreenStatisticsId);

            appDbBrowishGreenStatisticsService.saveOrUpdate(appDbBrowishGreenStatistics);

//            //收青id
//            Long id = appDbBrowishGreenStatistics.getId();
            //拿到收青id之后存收青人员信息


            //收青人员表
            for (AppDbBrowishGreenPerson appDbBrowishGreenPerson : appDbBrowishGreenPersonList) {
                appDbBrowishGreenPerson.setTeaId(teaId);
                appDbBrowishGreenPerson.setBrowishGreenStatisticsDate(date);
                appDbBrowishGreenPerson.setBrowishGreenStatisticsId(browishGreenStatisticsId);
                appDbBrowishGreenPersonService.save(appDbBrowishGreenPerson);
            }
            //存完收青人员信息之后再统计收青总数

            //获取当天收青总数
            List<AppDbBrowishGreenPerson> list1 = appDbBrowishGreenPersonService.lambdaQuery()
                .eq(AppDbBrowishGreenPerson::getBrowishGreenStatisticsId, browishGreenStatisticsId)
                .list();
            double finalFirstLevel = list1.stream().mapToDouble(AppDbBrowishGreenPerson::getBrowishGreenFirstLevel).sum();
            double finalSecondLevel = list1.stream().mapToDouble(AppDbBrowishGreenPerson::getBrowishGreenSecondLevel).sum();

            appDbBrowishGreenStatisticsService.lambdaUpdate()
                .set(AppDbBrowishGreenStatistics::getFirstLevelAll, finalFirstLevel)
                .set(AppDbBrowishGreenStatistics::getSecondLevelAll, finalSecondLevel)
                .eq(AppDbBrowishGreenStatistics::getId, browishGreenStatisticsId)
                .update();


            List<AppDbBrowishGreenStatistics> list = appDbBrowishGreenStatisticsService.lambdaQuery()
                .eq(AppDbBrowishGreenStatistics::getTeaGardenId, insertBrowishGreenPersonDTO.getTeaId())
                .list();

            double firstGreenTea = list.stream()
                .filter(statistics -> statistics.getFirstLevelAll() != null)
                .mapToDouble(AppDbBrowishGreenStatistics::getFirstLevelAll)
                .sum();
            double secondGreenTea = list.stream()
                .filter(statistics -> statistics.getSecondLevelAll() != null)
                .mapToDouble(AppDbBrowishGreenStatistics::getSecondLevelAll)
                .sum();
            Long count = appDbAllGreenTeaStatisticsService.lambdaQuery()
                .eq(AppDbAllGreenTeaStatistics::getTeaId, insertBrowishGreenPersonDTO.getTeaId())
                .count();
            if (count != 0) {
                appDbAllGreenTeaStatisticsService.lambdaUpdate()
                    .set(AppDbAllGreenTeaStatistics::getFirstLevelGreenTea, firstGreenTea)
                    .set(AppDbAllGreenTeaStatistics::getSecondLevelGreenTea, secondGreenTea)
                    .eq(AppDbAllGreenTeaStatistics::getTeaId, insertBrowishGreenPersonDTO.getTeaId())
                    .update();
            }else {
                AppDbAllGreenTeaStatistics appDbAllGreenTeaStatistics = new AppDbAllGreenTeaStatistics();
                appDbAllGreenTeaStatistics.setFirstLevelGreenTea(firstGreenTea);
                appDbAllGreenTeaStatistics.setSecondLevelGreenTea(secondGreenTea);
                appDbAllGreenTeaStatistics.setTeaId(insertBrowishGreenPersonDTO.getTeaId());
                appDbAllGreenTeaStatisticsService.saveOrUpdate(appDbAllGreenTeaStatistics);
            }

            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("新增失败，请联系管理员");
        }
    }

    /**
     * 新增或修改收青人员
     */
    @PostMapping("/insertGreenTeaPeople")
    @SaIgnore
    @Transactional
    public R<Object> insertGreenTeaPeople(@RequestBody AppDbBrowishGreenPerson appDbBrowishGreenPerson){
        try {
            appDbBrowishGreenPersonService.saveOrUpdate(appDbBrowishGreenPerson);
            Long browishGreenStatisticsId = appDbBrowishGreenPerson.getBrowishGreenStatisticsId();
            List<AppDbBrowishGreenPerson> list = appDbBrowishGreenPersonService.lambdaQuery()
                .eq(AppDbBrowishGreenPerson::getBrowishGreenStatisticsId, browishGreenStatisticsId)
                .list();
            double firstLevelGreenTea = list.stream().mapToDouble(AppDbBrowishGreenPerson::getBrowishGreenFirstLevel).sum();
            double secondLevelGreenTea = list.stream().mapToDouble(AppDbBrowishGreenPerson::getBrowishGreenSecondLevel).sum();
            appDbBrowishGreenStatisticsService.lambdaUpdate()
                .set(AppDbBrowishGreenStatistics::getFirstLevelAll, firstLevelGreenTea)
                .set(AppDbBrowishGreenStatistics::getSecondLevelAll, secondLevelGreenTea)
                .eq(AppDbBrowishGreenStatistics::getId, browishGreenStatisticsId)
                .update();
            return R.ok("成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("失败");
        }
    }
}
