package com.htht.business.utils.vo;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.vo
 * @className: QuestionMsgVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/9 13:31
 * @version: 1.0
 */
@Data
public class QuestionMsgVo {

    /**
     * 问题总量
     */
    private Long questionCount;

    /**
     * 待回复
     */
    private Long notReply;

    /**
     * 已回复
     */
    private Long isReply;

    /**
     * 未回复占比率
     */
    private Double notReplyProportion;

    /**
     * 已回复占比率
     */
    private Double isReplyProportion;
}
