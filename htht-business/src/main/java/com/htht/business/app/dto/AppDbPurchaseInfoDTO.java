package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbPurchaseInfoDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/4/8 17:24
 * @version: 1.0
 */
@Data
public class AppDbPurchaseInfoDTO {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 求购类型(0 急购 1 采购)
     */
    private String type;

    /**
     * 采购量
     */
    private String amountPurchased;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 发布人
     */
    private String publisher;

    /**
     * 发布人id
     */
    private Long publisherId;

    /**
     * 求购标题
     */
    private String purchaseInformation;
}
