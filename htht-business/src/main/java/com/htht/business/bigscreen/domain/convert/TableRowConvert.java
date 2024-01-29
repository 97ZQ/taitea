package com.htht.business.bigscreen.domain.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TableRowConvert {
    TableRowConvert INSTANCE = Mappers.getMapper(TableRowConvert.class);


//    @ValueMapping(source = "tableColValList", target = MappingConstants.NULL)
//    Map<String, Object> toTableMap(TableRow tableRow);
//
//    List<TableInfoVo> tableColValListToMap(TableColVal[] tableColValList);

}
