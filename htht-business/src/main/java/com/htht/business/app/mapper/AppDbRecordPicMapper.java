package com.htht.business.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htht.business.app.domain.AppDbMyTeaGarden;
import com.htht.business.app.domain.AppDbRecordPic;
import org.mapstruct.Mapper;


import java.util.List;

/**
 * @Entity com.htht.business.app.domain.AppDbTeaPic
 */

public interface AppDbRecordPicMapper extends BaseMapper<AppDbRecordPic> {

    List<AppDbRecordPic> selectByRecordId(Long recordId);
}




