package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbAgriculturalInfoDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/8 10:37
 * @version: 1.0
 */
@Data
public class AppDbAgriculturalInfoDTO extends PageQuery {

    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 主营
     */
    private String mainBusiness;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * (0 待审批 1 审批通过 2 审批不通过)
     */
    private String status;

    /**
     * 申请人id
     */
    private String applicantId;

    /**
     * 地区
     */
    private String district;

    /**
     * 申请时间
     */
    private Date applicantTime;
}
