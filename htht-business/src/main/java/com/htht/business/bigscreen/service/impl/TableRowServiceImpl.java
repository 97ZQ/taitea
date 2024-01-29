package com.htht.business.bigscreen.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.htht.business.bigscreen.domain.TableRow;
import com.htht.business.bigscreen.domain.prop.TableColVal;
import com.htht.business.bigscreen.mapper.TableRowMapper;
import com.htht.business.bigscreen.service.ITableRowService;
import com.htht.common.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TableRowServiceImpl implements ITableRowService {

    private final TableRowMapper tableRowMapper;

    @Override
    public void add(TableRow tableRow) {
        int insert = tableRowMapper.insert(tableRow);
        if (insert != 1) {
            throw new ServiceException("新增表失败");
        }
    }

    @Override
    public void upd(TableRow tableRow) {
        int updateById = tableRowMapper.updateById(tableRow);
        if (updateById != 1) {
            throw new ServiceException("更新表失败");
        }
    }

    @Override
    public void delByTableInfoId(String tableInfoId) {
        int delete = tableRowMapper.delete(Wrappers.lambdaQuery(TableRow.class).eq(TableRow::getTableInfoId, tableInfoId));
    }

    @Override
    public void delKey(String tableInfoId, String key) {
        boolean update = ChainWrappers.lambdaUpdateChain(tableRowMapper)
            .setSql("table_col_val_array = JSON_REMOVE(table_col_val_array, '$." + key + "')")
            .eq(TableRow::getTableInfoId, tableInfoId)
            .update();
        if (!update) {
            throw new ServiceException("删除列失败");
        }
    }

    @Override
    public void addRows(String tableInfoId, List<Map<String, Object>> rows) {
        List<TableRow> tableRows = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            TableRow tableRow = new TableRow();
            tableRow.setTableInfoId(tableInfoId);
            TableColVal[] tableColValArray = new TableColVal[row.size()];
            Set<String> keySet = row.keySet();
            int i = 0;
            for (String key : keySet) {
                TableColVal tableColVal = new TableColVal();
                tableColVal.setKey(key);
                tableColVal.setVal(row.get(key));
                tableColValArray[i] = tableColVal;
                i++;
            }
            tableRow.setTableColValArray(tableColValArray);
            tableRows.add(tableRow);
        }
        tableRowMapper.insertBatch(tableRows);
    }

    @Override
    public List<TableRow> listByTableInfoIds(List<String> tableInfoIds) {
        if (tableInfoIds.size() == 0) {
            return Collections.emptyList();
        }
        return tableRowMapper.selectList(Wrappers.lambdaQuery(TableRow.class).in(TableRow::getTableInfoId, tableInfoIds).orderByAsc(TableRow::getCreateTime));
    }
}
