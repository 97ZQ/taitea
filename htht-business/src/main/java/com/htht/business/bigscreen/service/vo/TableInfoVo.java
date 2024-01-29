package com.htht.business.bigscreen.service.vo;

import com.htht.business.bigscreen.domain.TableInfo;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TableInfoVo extends TableInfo {

    /**
     * 表数据
     */
    private List<Map<String, Object>> tableData;

}
