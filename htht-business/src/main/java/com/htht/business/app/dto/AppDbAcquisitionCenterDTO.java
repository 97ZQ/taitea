package com.htht.business.app.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.common.core.domain.PageQuery;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: AppDbAcquisitionCenterDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/28 14:27
 * @version: 1.0
 */
@Data
public class AppDbAcquisitionCenterDTO extends PageQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 采集标题 对应填的是  fileName
     */
    private String captureTitle;

    /**
     * 采购量
     */
    private String quantityPurchased;

    /**
     * 截止时间
     */
    private Date cutOffTime;

    /**
     * 附件地址
     */
    private String attachments;

    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 静态文件地址
     */
    private String staticPath;
}
