package com.htht.business.app.vo;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.app.vo
 * @className: AppDbFinishedTeaVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/4/2 16:15
 * @version: 1.0
 */
@Data
public class AppDbFinishedTeaVo {

    /**
     * 一级绿茶
     */
    private Integer greenTeaFirstLevel;

    /**
     * 二级绿茶
     */
    private Integer greenTeaSecondLevel;

    /**
     * 一级红茶
     */
    private Integer redTeaFirstLevel;

    /**
     * 二级红茶
     */
    private Integer redTeaSecondLevel;
}
