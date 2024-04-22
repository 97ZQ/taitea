package com.htht.business.app.dto;

import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: CreateDateDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/28 11:33
 * @version: 1.0
 */
@Data
public class CreateDateDTO {
    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 日期(月：yyyy-MM) 或日（yyyy-MM-dd）
     */
    private String date;

    /**
     * 当前月(0：是 1：不是)
     */
    private Integer theMonth;
}
