package com.htht.business.source.domain.prop;

import lombok.Data;

/**
 * 溯源检测文件信息
 */
@Data
public class SourceFile {

    /**
     * 文件类型（前端用）
     */
    private Integer type;

    /**
     * 文件id
     */
    private String fileId;

    /**
     * 静态路径
     */
    private String staticPath;

    /**
     * 文件名
     */
    private String fileName;

}
