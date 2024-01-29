package com.htht.business.bigscreen.service;

import com.htht.business.bigscreen.domain.TableRow;

import java.util.List;
import java.util.Map;

public interface ITableRowService {

    void add(TableRow tableRow);

    void upd(TableRow tableRow);

    void delByTableInfoId(String tableInfoId);

    void delKey(String tableInfoId, String key);

    void addRows(String tableInfoId, List<Map<String, Object>> rows);

    List<TableRow> listByTableInfoIds(List<String> tableInfoIds);

}
