package com.htht.business.app.dto;

import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbExpertOnlineDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/6 15:55
 * @version: 1.0
 */
@Data
public class AppDbExpertOnlineDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 类型
     */
    private String questionType;

    /**
     * 状态(0 待回复 1 已回复)
     */
    private String status;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 问题的内容
     */
    private String questionContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 回复内容
     */
    private String replyContent;
}
