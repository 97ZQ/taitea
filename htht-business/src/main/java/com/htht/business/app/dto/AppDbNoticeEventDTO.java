package com.htht.business.app.dto;

import com.htht.business.thirty.equip.utils.Page;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbNoticeEventDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 10:28
 * @version: 1.0
 */
@Data
public class AppDbNoticeEventDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 活动公告
     */
    private String noticeContent;

    /**
     * 活动标题
     */
    private String noticeTitle;

    /**
     * 活动日期
     */
    private Date noticeDate;

    /**
     * 活动类型
     */
    private String type;

    /**
     * 发布单位
     */
    private String noticeUnit;
}
