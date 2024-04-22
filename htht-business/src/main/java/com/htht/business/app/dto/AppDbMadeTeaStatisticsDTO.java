package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbMadeTeaStatisticsDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/26 16:52
 * @version: 1.0
 */
@Data
public class AppDbMadeTeaStatisticsDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 一级绿茶
     */
    private String greenTeaFirstLevel;

    /**
     * 二级绿茶
     */
    private String greenTeaSecondLevel;

    /**
     * 一级红茶
     */
    private String redTeaFirstLevel;

    /**
     * 二级红茶
     */
    private String redTeaSecondLevel;

    /**
     * 成品茶统计日期
     */
    private Date finishedTeaStatisticsDate;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;

    /**
     * 茶园id
     */
    private Long teaId;
}
