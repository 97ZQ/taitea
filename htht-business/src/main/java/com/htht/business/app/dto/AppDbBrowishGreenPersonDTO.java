package com.htht.business.app.dto;

import com.htht.common.core.domain.PageQuery;
import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbBrowishGreenPersonDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/25 1:02
 * @version: 1.0
 */
@Data
public class AppDbBrowishGreenPersonDTO extends PageQuery {

    /**
     * 收青id
     */
    private Long browishGreenStatisticsId;

    /**
     * 茶园id
     */
    private Long TeaId;

    /**
     * 收青日期
     */
    private String date;
}
