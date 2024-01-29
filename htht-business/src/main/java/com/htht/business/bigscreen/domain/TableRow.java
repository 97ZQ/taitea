package com.htht.business.bigscreen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.htht.business.bigscreen.domain.prop.TableColVal;
import com.htht.common.core.domain.BaseEntity;
import lombok.Data;

@TableName(autoResultMap = true)
@Data
public class TableRow extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long tableRowId;

    /**
     * 表信息id
     */
    private String tableInfoId;

    /**
     * 对应表的一行数据
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private TableColVal[] tableColValArray;

}
