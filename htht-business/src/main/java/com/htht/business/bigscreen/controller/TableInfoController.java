package com.htht.business.bigscreen.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.bigscreen.domain.TableInfo;
import com.htht.business.bigscreen.domain.prop.TableCol;
import com.htht.business.bigscreen.service.ITableInfoService;
import com.htht.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 表信息
 */
@SaIgnore
@RestController
@RequestMapping("/tableInfo")
@RequiredArgsConstructor
public class TableInfoController {

    private final ITableInfoService iTableInfoService;

    /**
     * 新增表信息
     *
     * @param tableInfo 实体
     */
    @PostMapping("/add")
    public R add(@RequestBody TableInfo tableInfo) {
        iTableInfoService.add(tableInfo);
        return R.ok();
    }

    /**
     * 新增表的列
     *
     * @param tableInfoKey 表的key
     * @param tableCol     列
     */
    @PutMapping("/addCol")
    public R addCol(String tableInfoKey, TableCol tableCol) {
        iTableInfoService.addCol(tableInfoKey, tableCol);
        return R.ok();
    }

    /**
     * 更新表的列（无法更新列的key）
     *
     * @param tableInfoKey 表的key
     * @param tableCol     列
     */
    @PutMapping("/updCol")
    public R updCol(String tableInfoKey, TableCol tableCol) {
        iTableInfoService.updCol(tableInfoKey, tableCol);
        return R.ok();
    }

    /**
     * 删除表
     *
     * @param tableInfoId 表信息id
     */
    @DeleteMapping("/del")
    public R del(String tableInfoId) {
        iTableInfoService.del(tableInfoId);
        return R.ok();
    }

    /**
     * 删除列
     *
     * @param tableInfoKey 表的key
     * @param tableColKey  列的key
     */
    @DeleteMapping("/delCol")
    public R delCol(String tableInfoKey, String tableColKey) {
        iTableInfoService.delCol(tableInfoKey, tableColKey);
        return R.ok();
    }

    /**
     * 增加表数据
     *
     * @param tableInfoKey 表的key
     * @param rows         行数据
     */
    @PostMapping("/addRows")
    public R addRows(String tableInfoKey, @RequestBody List<Map<String, Object>> rows) {
        iTableInfoService.addRows(tableInfoKey, rows);
        return R.ok();
    }

    /**
     * 查询列表信息和数据
     *
     * @param tableInfoKeys 表的key列表
     */
    @GetMapping("/list")
    public R list(@RequestParam("tableInfoKeys") List<String> tableInfoKeys) {
        return R.ok(iTableInfoService.list(tableInfoKeys));
    }

}
