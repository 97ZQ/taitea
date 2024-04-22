package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbFarmRecordDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/26 1:25
 * @version: 1.0
 */
@Data
public class AppDbFarmRecordDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 茶园id
     */
    private Long teaGardenId;

    /**
     * 农事类型(0 施肥 1 浇水 2 松土 3其他)
     */
    private String farmingType;

    /**
     * 内容描述
     */
    private String workContent;

    /**
     * 工作人员名称
     */
    private String workName;

    /**
     * 农事记录日期
     */
    private Date workDate;
}
