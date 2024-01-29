package com.htht.business.bigscreen.service;

import com.htht.business.bigscreen.domain.TableInfo;
import com.htht.business.bigscreen.domain.prop.TableCol;
import com.htht.business.bigscreen.service.vo.TableInfoVo;

import java.util.List;
import java.util.Map;

public interface ITableInfoService {

    void add(TableInfo tableInfo);

    void addCol(String tableInfoKey, TableCol tableCol);

    void updCol(String tableInfoKey, TableCol tableCol);

    void del(String tableInfoId);

    void delCol(String tableInfoKey, String tableColKey);

    void addRows(String tableInfoKey, List<Map<String, Object>> rows);

    List<TableInfoVo> list(List<String> tableInfoKeys);

}
