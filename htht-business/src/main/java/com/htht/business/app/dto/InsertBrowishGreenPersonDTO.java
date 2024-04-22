package com.htht.business.app.dto;

import com.htht.business.app.domain.AppDbBrowishGreenPerson;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: InsertBrowishGreenPersonDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/25 14:40
 * @version: 1.0
 */
@Data
public class InsertBrowishGreenPersonDTO {
    /**
     * 收青id
     */
    private Long browishGreenStatisticsId;


    /**
     * 茶园id
     */
    private Long teaId;

    /**
     * 收青日期
     */
    private Date date;

    /**
     * 收青人员
     */
    private List<AppDbBrowishGreenPerson> appDbBrowishGreenPersonList;
}
