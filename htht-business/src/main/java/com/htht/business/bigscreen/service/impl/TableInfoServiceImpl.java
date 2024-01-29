package com.htht.business.bigscreen.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.htht.business.bigscreen.domain.TableInfo;
import com.htht.business.bigscreen.domain.TableRow;
import com.htht.business.bigscreen.domain.convert.TableInfoConvert;
import com.htht.business.bigscreen.domain.prop.TableCol;
import com.htht.business.bigscreen.domain.prop.TableColVal;
import com.htht.business.bigscreen.mapper.TableInfoMapper;
import com.htht.business.bigscreen.service.ITableInfoService;
import com.htht.business.bigscreen.service.ITableRowService;
import com.htht.business.bigscreen.service.vo.TableInfoVo;
import com.htht.common.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableInfoServiceImpl implements ITableInfoService {

    private static final TableInfoConvert TABLE_INFO_CONVERT = TableInfoConvert.INSTANCE;

    private final TableInfoMapper tableInfoMapper;
    private final ITableRowService iTableRowService;

    @Override
    public void add(TableInfo tableInfo) {
        validateTableInfoExist(tableInfo.getTableKey(), false);

        TableCol[] tableCols = tableInfo.getTableCols();
        if (tableCols != null && tableCols.length > 0) {
            long count = Arrays.stream(tableCols).distinct().count();
            if (count != tableCols.length) {
                throw new ServiceException("列必须唯一");
            }
        }

        int insert = tableInfoMapper.insert(tableInfo);
        if (insert != 1) {
            throw new ServiceException("新增表失败");
        }
    }

    @Override
    public void addCol(String tableInfoKey, TableCol tableCol) {
        TableInfo exiTableInfo = validateTableInfoExist(tableInfoKey, true);
        TableCol[] tableCols = exiTableInfo.getTableCols();
        if (tableCols == null) {
            tableCols = new TableCol[0];
        } else {
            for (TableCol col : tableCols) {
                if (col.getKey().equals(tableCol.getKey())) {
                    throw new ServiceException("列已存在");
                }
            }
        }
        TableCol[] newTableCols = new TableCol[tableCols.length + 1];
        System.arraycopy(tableCols, 0, newTableCols, 0, tableCols.length);
        newTableCols[newTableCols.length - 1] = tableCol;

        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableInfoId(exiTableInfo.getTableInfoId());
        tableInfo.setTableCols(newTableCols);
        int updateById = tableInfoMapper.updateById(tableInfo);
        if (updateById != 1) {
            throw new ServiceException("更新表的列失败");
        }
    }

    @Override
    public void updCol(String tableInfoKey, TableCol tableCol) {
        TableInfo exiTableInfo = validateTableInfoExist(tableInfoKey, true);

        TableCol[] tableCols = exiTableInfo.getTableCols();
        if (tableCols == null || tableCols.length == 0) {
            throw new ServiceException("列不存在");
        }
        boolean isExist = false;
        for (TableCol col : tableCols) {
            if (col.equals(tableCol)) {
                isExist = true;
                TABLE_INFO_CONVERT.updTableCol(tableCol, col);
            }
        }
        if (!isExist) {
            throw new ServiceException("列不存在");
        }

        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableInfoId(exiTableInfo.getTableInfoId());
        tableInfo.setTableCols(tableCols);
        int updateById = tableInfoMapper.updateById(tableInfo);
        if (updateById != 1) {
            throw new ServiceException("更新表的列失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delCol(String tableInfoKey, String tableColKey) {
        TableInfo exiTableInfo = validateTableInfoExist(tableInfoKey, true);

        TableCol[] tableCols = exiTableInfo.getTableCols();
        if (tableCols == null || tableCols.length == 0) {
            throw new ServiceException("列不存在");
        }
        TableCol[] newTableCols = new TableCol[tableCols.length - 1];
        int ni = 0;
        for (TableCol tableCol : tableCols) {
            if (!tableCol.getKey().equals(tableColKey)) {
                newTableCols[ni] = tableCol;
                ni++;
            }
        }

        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableInfoId(exiTableInfo.getTableInfoId());
        tableInfo.setTableCols(newTableCols);
        int updateById = tableInfoMapper.updateById(tableInfo);
        if (updateById != 1) {
            throw new ServiceException("更新表的列失败");
        }

        iTableRowService.delKey(exiTableInfo.getTableInfoId(), tableColKey);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRows(String tableInfoKey, List<Map<String, Object>> rows) {
        TableInfo exiTableInfo = validateTableInfoExist(tableInfoKey, true);

        iTableRowService.addRows(exiTableInfo.getTableInfoId(), rows);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void del(String tableInfoId) {
        int deleteById = tableInfoMapper.deleteById(tableInfoId);
        if (deleteById != 1) {
            throw new ServiceException("删除表失败");
        }

        iTableRowService.delByTableInfoId(tableInfoId);
    }

    @Override
    public List<TableInfoVo> list(List<String> tableInfoKeys) {
        if (tableInfoKeys.size() == 0) {
            return Collections.emptyList();
        }
        List<TableInfo> tableInfos = tableInfoMapper.selectVoList(Wrappers.lambdaQuery(TableInfo.class).in(TableInfo::getTableKey, tableInfoKeys));
        if (tableInfos.size() == 0) {
            return Collections.emptyList();
        }
        List<TableInfoVo> tableInfoVos = TABLE_INFO_CONVERT.toTableInfoVoList(tableInfos);

        List<String> tableInfoIds = tableInfos.stream().map(TableInfo::getTableInfoId).collect(Collectors.toList());
        List<TableRow> tableRows = iTableRowService.listByTableInfoIds(tableInfoIds);
        if (tableRows.size() == 0) {
            return tableInfoVos;
        }

        for (TableInfoVo tableInfoVo : tableInfoVos) {
            List<Map<String, Object>> tableData = new ArrayList<>();
            for (TableRow tableRow : tableRows) {
                if (tableRow.getTableInfoId().equals(tableInfoVo.getTableInfoId())) {
                    Map<String, Object> row = new HashMap<>();
                    tableData.add(row);
                    row.put("tableRowId", tableRow.getTableRowId());
                    row.put("tableInfoId", tableInfoVo.getTableInfoId());
                    row.put("createTime", tableRow.getCreateTime());
                    TableColVal[] tableColValArray = tableRow.getTableColValArray();
                    if (tableColValArray == null || tableColValArray.length == 0) {
                        continue;
                    }
                    for (TableColVal tableColVal : tableColValArray) {
                        row.put(tableColVal.getKey(), tableColVal.getVal());
                    }
                }
            }
            tableInfoVo.setTableData(tableData);
        }
        return tableInfoVos;
    }

    private TableInfo validateTableInfoExist(String tableInfoKey, boolean isShouldExist) {
        TableInfo exiTableInfo = tableInfoMapper.selectVoOne(
            Wrappers.lambdaQuery(TableInfo.class).eq(TableInfo::getTableKey, tableInfoKey)
        );
        if (isShouldExist) {
            if (exiTableInfo == null) {
                throw new ServiceException("表不存在");
            }
        } else {
            if (exiTableInfo != null) {
                throw new ServiceException("表已存在");
            }
        }
        return exiTableInfo;
    }

}
