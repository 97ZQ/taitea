package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbRawTeaStatisticsDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/27 2:02
 * @version: 1.0
 */
@Data
public class AppDbRawTeaStatisticsDTO {
    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 茶厂id
     */
    private Long teaFactoryId;
}
