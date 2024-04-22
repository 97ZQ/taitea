package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dtflys.forest.annotation.Get;
import com.htht.business.app.domain.AppDbMyTeaGarden;
import com.htht.business.app.domain.AppDbTeaPic;
import com.htht.business.app.dto.AppDbMyTeaGardenDTO;
import com.htht.business.app.dto.PicDTO;
import com.htht.business.app.mapper.AppDbTeaPicMapper;
import com.htht.business.app.service.AppDbMyTeaFactoryService;
import com.htht.business.app.service.AppDbMyTeaGardenService;
import com.htht.business.app.service.AppDbTeaPicService;
import com.htht.business.app.vo.AppDbMyTeaGardenVo;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import com.htht.system.domain.SysFile;
import com.htht.system.service.ISysFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 我的茶园
 * @projectName: htht
 * @package: com.htht.business.app.controller
 * @className: MyTeaGardenController
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/22 17:12
 * @version: 1.0
 */
@RequestMapping("/myTeaGarden")
@RestController
@RequiredArgsConstructor
@SaIgnore
public class MyTeaGardenController {

    private final AppDbMyTeaGardenService appDbMyTeaGardenService;

    private final AppDbMyTeaFactoryService appDbMyTeaFactoryService;

    private final AppDbTeaPicService appDbTeaPicService;

    private final ISysFileService iSysFileService;

    private final AppDbTeaPicMapper appDbTeaPicMapper;

    @Value("${file.root-path}")
    private String path;

    /**
     * 查询
     * @return
     */
    @GetMapping("/list")
    @SaIgnore
    public R<Object> list(){
        List<AppDbMyTeaGarden> appDbMyTeaGardenList = appDbMyTeaGardenService.selectList();
        int size = appDbMyTeaGardenList.size();
        if (size != 0){
            return R.ok(appDbMyTeaGardenService.selectList());
        }else {
            return R.fail("没有入驻，请申请入驻");
        }

    }

    /**
     * 修改茶园管理后台
     */
    @PostMapping("/myTeaManagement")
    @SaIgnore
    @Transactional
    public R<Object> myTeaManagement(@RequestBody AppDbMyTeaGardenDTO appDbMyTeaGardenDTO){
        try {
            if (appDbMyTeaGardenDTO.getStaticPathList() != null) {
                //茶园图片List
                List<PicDTO> picDTOList = appDbMyTeaGardenDTO.getStaticPathList();
                AppDbTeaPic appDbTeaPicDelete = new AppDbTeaPic();
                appDbTeaPicDelete.setTeaId(appDbMyTeaGardenDTO.getId());
                QueryWrapper<AppDbTeaPic> appDbTeaPicQueryWrapper = new QueryWrapper<>(appDbTeaPicDelete);
                appDbTeaPicMapper.delete(appDbTeaPicQueryWrapper);
                for (PicDTO picDTO : picDTOList) {
                    AppDbTeaPic appDbTeaPic = new AppDbTeaPic();
                    appDbTeaPic.setFileId(picDTO.getFileId());
                    appDbTeaPic.setTeaId(appDbMyTeaGardenDTO.getId());
                    appDbTeaPic.setFileStaticPath(picDTO.getStaticPath());
                    appDbTeaPicService.saveOrUpdate(appDbTeaPic);
                }
                AppDbMyTeaGarden appDbMyTeaGarden = new AppDbMyTeaGarden();
                if (appDbMyTeaGardenDTO.getId() != null) {
                    appDbMyTeaGarden.setId(appDbMyTeaGardenDTO.getId());
                    appDbMyTeaGarden.setTeaIntroduce(appDbMyTeaGardenDTO.getTeaIntroduce());
                    appDbMyTeaGarden.setTeaName(appDbMyTeaGardenDTO.getTeaName());
                    appDbMyTeaGarden.setVideoSurveillance(appDbMyTeaGardenDTO.getVideoSurveillance());
                    appDbMyTeaGarden.setWeatherStreet(appDbMyTeaGardenDTO.getWeatherStreet());
                    appDbMyTeaGardenService.saveOrUpdate(appDbMyTeaGarden);
                }else {
                    appDbMyTeaGarden.setTeaIntroduce(appDbMyTeaGardenDTO.getTeaIntroduce());
                    appDbMyTeaGarden.setTeaName(appDbMyTeaGardenDTO.getTeaName());
                    appDbMyTeaGarden.setVideoSurveillance(appDbMyTeaGardenDTO.getVideoSurveillance());
                    appDbMyTeaGarden.setWeatherStreet(appDbMyTeaGardenDTO.getWeatherStreet());
                    appDbMyTeaGardenService.saveOrUpdate(appDbMyTeaGarden);
                }
            }else {
                AppDbMyTeaGarden appDbMyTeaGarden = new AppDbMyTeaGarden();
                appDbMyTeaGarden.setId(appDbMyTeaGarden.getId());
                appDbMyTeaGarden.setTeaName(appDbMyTeaGarden.getTeaName());
                appDbMyTeaGarden.setTeaIntroduce(appDbMyTeaGarden.getTeaIntroduce());
            }
            return R.ok("提交成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("提交失败，请联系管理员");
        }
    }

    /**
     * 根据茶园id查询茶园信息
     */
    @GetMapping("/getMyTeaGardenMsg")
    @SaIgnore
    public R<AppDbMyTeaGardenVo> getMyTeaGardenMsg(Long teaId){
        AppDbMyTeaGarden appDbMyTeaGarden = appDbMyTeaGardenService.getById(teaId);
//        List<String> staticPathList = new ArrayList<>();
//        staticPathList.add(appDbMyTeaGarden.getCarouselMapStaticPath());
        AppDbMyTeaGardenVo appDbMyTeaGardenVo = new AppDbMyTeaGardenVo();
        List<AppDbTeaPic> teaPicList = appDbTeaPicService.lambdaQuery()
            .eq(AppDbTeaPic::getTeaId, teaId)
            .list();
        List<PicDTO> picDTOList = new ArrayList<>();
        for (AppDbTeaPic appDbTeaPic : teaPicList) {
            PicDTO picDTO = new PicDTO();
            picDTO.setStaticPath(appDbTeaPic.getFileStaticPath());
            picDTO.setFileId(appDbTeaPic.getFileId());
            picDTOList.add(picDTO);
        }
        appDbMyTeaGardenVo.setId(appDbMyTeaGarden.getId());
        appDbMyTeaGardenVo.setStaticPathList(picDTOList);
        appDbMyTeaGardenVo.setTeaName(appDbMyTeaGarden.getTeaName());
        appDbMyTeaGardenVo.setTeaIntroduce(appDbMyTeaGarden.getTeaIntroduce());
        appDbMyTeaGardenVo.setWeatherStreet(appDbMyTeaGarden.getWeatherStreet());
        appDbMyTeaGardenVo.setVideoSurveillance(appDbMyTeaGarden.getVideoSurveillance());


        return R.ok(appDbMyTeaGardenVo);
    }

    /**
     * 显示静态图片
     */
    @PostMapping("/checkStaticPic")
    @SaIgnore
    public R staticFile(@RequestPart("file") MultipartFile file) {
        String name = file.getOriginalFilename();
        String folder = name.substring(name.lastIndexOf(".") + 1);
        SysFile sysFile = iSysFileService.upload(file, path+"/static", folder, true);
        SysFile sysFile1 = new SysFile();
        sysFile1.setCreateBy(sysFile.getCreateBy());
        sysFile1.setCreateTime(sysFile.getCreateTime());
        sysFile1.setUpdateBy(sysFile.getUpdateBy());
        sysFile1.setUpdateTime(sysFile.getUpdateTime());
        sysFile1.setId(sysFile.getId());
        sysFile1.setFileName(sysFile.getFileName());
        sysFile1.setExtension(sysFile.getExtension());
        sysFile1.setTotalSize(sysFile.getTotalSize());
        sysFile1.setStaticPath("/static/" + sysFile.getStaticPath());
        sysFile1.setIsStatic(sysFile.getIsStatic());
        sysFile1.setFilePath(sysFile.getFilePath());

        return R.ok(sysFile1);
    }

}
