package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppUseRawTeaDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/27 2:10
 * @version: 1.0
 */
@Data
public class AppDbUseRawTeaDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 一级绿毛茶使用量
     */
    private Double useFirstLevelGreenRawTea;

    /**
     * 二级绿毛茶使用量
     */
    private Double useSecondLevelGreenRawTea;

    /**
     * 一级红毛茶使用量
     */
    private Double useFirstLevelRedRawTea;

    /**
     * 二级红毛茶使用量
     */
    private Double useSecondLevelRedRawTea;

    /**
     * 使用日期
     */
    private Date useTime;

    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;
}
