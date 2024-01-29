package com.htht.business.bigscreen.domain.convert;

import com.htht.business.bigscreen.domain.TableInfo;
import com.htht.business.bigscreen.domain.prop.TableCol;
import com.htht.business.bigscreen.service.vo.TableInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface TableInfoConvert {
    TableInfoConvert INSTANCE = Mappers.getMapper(TableInfoConvert.class);

    TableInfoVo toTableInfoVo(TableInfo tableInfo);

    void updTableCol(TableCol source, @MappingTarget TableCol target);

    List<TableInfoVo> toTableInfoVoList(List<TableInfo> tableInfos);

}
