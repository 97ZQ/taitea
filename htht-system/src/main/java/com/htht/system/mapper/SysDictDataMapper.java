package com.htht.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.htht.common.constant.UserConstants;
import com.htht.common.core.domain.entity.SysDictData;
import com.htht.common.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 字典表 数据层
 *
 * @author Lion Li
 */
public interface SysDictDataMapper extends BaseMapperPlus<SysDictDataMapper, SysDictData, SysDictData> {

    default List<SysDictData> selectDictDataByType(String dictType) {
        return selectList(
            new LambdaQueryWrapper<SysDictData>()
                .eq(SysDictData::getStatus, UserConstants.DICT_NORMAL)
                .eq(SysDictData::getDictType, dictType)
                .orderByAsc(SysDictData::getDictSort));
    }
}
