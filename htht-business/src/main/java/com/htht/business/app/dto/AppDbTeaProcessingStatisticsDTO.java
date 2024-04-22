package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbTeaProcessingStatisticsDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/26 2:16
 * @version: 1.0
 */
@Data
public class AppDbTeaProcessingStatisticsDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;

    /**
     * 加工时间
     */
    private Date processingDate;

    /**
     * 加工茶青等级(0 一级 1二级)
     */
    private String processingTeaLevel;

    /**
     * 茶青重量(斤)
     */
    private String teaGreenWeight;

    /**
     * 产出类型(0 绿毛茶 1红毛茶)
     */
    private String teaOutputType;

    /**
     * 产出毛茶(斤)
     */
    private String teaOutputQuantity;

    /**
     * 茶园id
     */
    private Long teaId;
}
