package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbPolicyMsgDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 16:38
 * @version: 1.0
 */
@Data
public class AppDbPolicyMsgDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String policyContent;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 发布人
     */
    private String publisher;
}
