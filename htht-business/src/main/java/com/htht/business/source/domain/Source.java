package com.htht.business.source.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.htht.business.source.domain.prop.SourceFile;
import com.htht.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 溯源管理
 */
@TableName(autoResultMap = true)
@Data
public class Source extends BaseEntity {

    @TableId
    private String sourceId;

    /**
     * 溯源码
     */
    private String code;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品类型，0：红茶，1：绿茶，2：乌龙茶
     */
    private String type;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 所属区域
     */
    private String belongRegion;

    /**
     * 施肥类型，0：有机肥，1：无机肥
     */
    private String ferType;

    /**
     * 采摘日期
     */
    private Date pickDate;

    /**
     * 加工流程，0：鲜叶、1：摊青、2：杀青、3：揉捻、4：解块、5：干燥、6：精制、7:包装、8：成品
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private String[] processFlow;

    /**
     * 出厂批次号
     */
    private String outFactoryBatchNo;

    /**
     * 检测报告文件信息数组
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private SourceFile[] files;

//    /**
//     * 农残报告
//     */
//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private SourceFile pesResFile;
//
//    /**
//     * 食品检测报告
//     */
//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private SourceFile foodInsFile;
//
//    /**
//     * 有机检测报告
//     */
//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private SourceFile orgFile;

//    /**
//     * 摄像头id数组
//     */
//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private String[] videoIds;

    /**
     * 摄像头id
     */
    private String videoId;

//    /**
//     * 监测设备id数组
//     */
//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private String[] monitorEquIds;

    /**
     * 监测设备id数组
     */
    private String monitorEquId;

    /**
     * 产地介绍
     */
    private String locDesc;

}
