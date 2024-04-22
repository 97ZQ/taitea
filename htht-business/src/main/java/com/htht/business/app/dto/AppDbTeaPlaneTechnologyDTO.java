package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbTeaPlaneTechnologyDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/7 14:39
 * @version: 1.0
 */
@Data
public class AppDbTeaPlaneTechnologyDTO extends PageQuery {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 发布单位
     */
    private String publishUnit;

    /**
     * 静态地址
     */
    private String staticPath;
}
