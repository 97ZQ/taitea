package com.htht.business.app.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.htht.business.app.domain.AppDbFarmRecord;
import com.htht.business.app.domain.AppDbRecordPic;
import com.htht.business.app.domain.AppDbTeaPic;
import com.htht.business.app.dto.AppDbFarmRecordDTO;
import com.htht.business.app.dto.PicDTO;
import com.htht.business.app.mapper.AppDbFarmRecordMapper;
import com.htht.business.app.mapper.AppDbRecordPicMapper;
import com.htht.business.app.mapper.AppDbTeaPicMapper;
import com.htht.business.app.service.AppDbFarmRecordService;
import com.htht.business.app.service.AppDbRecordPicService;
import com.htht.common.core.domain.R;
import com.htht.common.core.page.TableDataInfo;
import com.htht.system.domain.SysFile;
import com.htht.system.service.ISysFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private final AppDbFarmRecordMapper appDbFarmRecordMapper;

    private final AppDbRecordPicMapper appDbRecordPicMapper;

    private final AppDbRecordPicService appDbRecordPicService;
    private final ISysFileService iSysFileService;

    @Value("${file.root-path}")
    private String path;
    /**
     * 查询农事记录
     */
    @PostMapping("/selectFarmRecord")
    @SaIgnore
    public TableDataInfo<AppDbFarmRecord> selectFarmRecord(@RequestBody AppDbFarmRecordDTO appDbFarmRecordDTO){
        return appDbFarmRecordService.selectFarmRecord(appDbFarmRecordDTO);
    }

//    /**
//     * 新增或编辑农事记录
//     */
//    @PostMapping("/insertOrUpdateFarmRecord")
//    @SaIgnore
//    @Transactional
//    public R<Object> insertOrUpdateFarmRecord(@RequestBody AppDbFarmRecord appDbFarmRecord){
//        try {
//            appDbFarmRecordService.saveOrUpdate(appDbFarmRecord);
//            return R.ok("成功");
//        }catch (Exception e){
//            e.printStackTrace();
//            return R.fail("失败,请联系管理员");
//        }
//    }

    /**
     * 新增或编辑农事记录
     */
    @PostMapping("/insertOrUpdateFarmRecord")
    @SaIgnore
    @Transactional
    public R<Object> insertOrUpdateFarmRecord(@RequestBody AppDbFarmRecordDTO appDbFarmRecordDTO){

        try {
            AppDbFarmRecord appDbFarmRecord = new AppDbFarmRecord();
            BeanUtils.copyProperties(appDbFarmRecordDTO,appDbFarmRecord);
            Long recordId = appDbFarmRecordDTO.getId();
            if(recordId == null){
                appDbFarmRecordMapper.insertReturnId(appDbFarmRecord);
                recordId = appDbFarmRecord.getId();
            }else{
                List<PicDTO> picDTOList = appDbFarmRecordDTO.getStaticPathList();
                AppDbRecordPic appDbRecordPicDelete = new AppDbRecordPic();
                appDbRecordPicDelete.setRecordId(recordId);
                QueryWrapper<AppDbRecordPic> appDbRecordPicQueryWrapper = new QueryWrapper<>(appDbRecordPicDelete);
                appDbRecordPicMapper.delete(appDbRecordPicQueryWrapper);
                appDbFarmRecordService.saveOrUpdate(appDbFarmRecord);
            }


            if(appDbFarmRecordDTO.getStaticPathList() != null && appDbFarmRecordDTO.getStaticPathList().size() > 0){
                List<PicDTO> picDTOList = appDbFarmRecordDTO.getStaticPathList();
                AppDbRecordPic appDbRecordPicDelete = new AppDbRecordPic();
                appDbRecordPicDelete.setId(recordId);
                QueryWrapper<AppDbRecordPic> appDbTeaPicQueryWrapper = new QueryWrapper<>(appDbRecordPicDelete);
                appDbRecordPicMapper.delete(appDbTeaPicQueryWrapper);
                for(PicDTO picDTO : picDTOList){
                    AppDbRecordPic appDbRecordPic = new AppDbRecordPic();
                    appDbRecordPic.setTeaId(appDbFarmRecordDTO.getTeaGardenId());
                    appDbRecordPic.setFileId(picDTO.getFileId());
                    appDbRecordPic.setRecordId(recordId);
                    appDbRecordPic.setFileStaticPath(picDTO.getStaticPath());
                    appDbRecordPicMapper.insert(appDbRecordPic);
                }
            }
            return R.ok("提交成功");

        }catch (Exception e){
            e.printStackTrace();
            return R.fail("失败,请联系管理员");
        }
    }

    /**
     * 根据农事记录id查看
     *
     * @param recordId 农事记录id
     * @return
     */
    @GetMapping("/selectById")
    @SaIgnore
    public AppDbFarmRecordDTO selectById(Long recordId) {

        AppDbFarmRecord appDbFarmRecord = appDbFarmRecordService.getById(recordId);
        AppDbFarmRecordDTO appDbFarmRecordDTO = new AppDbFarmRecordDTO();
        List<AppDbRecordPic> appDbRecordPics = appDbRecordPicMapper.selectByRecordId(recordId);
        List<AppDbRecordPic> teaPicList = appDbRecordPicService.lambdaQuery()
            .eq(AppDbRecordPic::getRecordId,recordId)
            .list();
        if(appDbFarmRecord == null){
            return new AppDbFarmRecordDTO();
        }

        BeanUtils.copyProperties(appDbFarmRecord, appDbFarmRecordDTO);
        List<PicDTO> picDTOList = new ArrayList<>();

        for (AppDbRecordPic appDbRecordPic : appDbRecordPics) {
            PicDTO picDTO = new PicDTO();
            picDTO.setStaticPath(appDbRecordPic.getFileStaticPath());
            picDTO.setFileId(appDbRecordPic.getFileId());
            picDTOList.add(picDTO);
        }
        appDbFarmRecordDTO.setStaticPathList(picDTOList);

        return appDbFarmRecordDTO;
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
