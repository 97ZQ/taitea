package com.htht.business.app.dto;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.app.dto
 * @className: PicDTO
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/4/1 10:18
 * @version: 1.0
 */
@Data
public class PicDTO {
    /**
     * 图片静态地址
     */
    private String staticPath;

    /**
     * 文件id
     */
    private Long fileId;
}
