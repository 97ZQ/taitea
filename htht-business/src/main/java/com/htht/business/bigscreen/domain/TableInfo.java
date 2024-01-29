package com.htht.business.bigscreen.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.htht.business.bigscreen.domain.prop.TableCol;
import com.htht.common.core.domain.BaseEntity;
import lombok.Data;

@TableName(autoResultMap = true)
@Data
public class TableInfo extends BaseEntity {

    @TableId
    private String tableInfoId;

    /**
     * 表唯一key，不为空（前端自定义）（唯一约束）
     */
    private String tableKey;

    /**
     * 表名称
     */
    private String name;

    /**
     * 列信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private TableCol[] tableCols;

    /**
     * 表的其他信息，由前端自定义
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object frontProp;

}
