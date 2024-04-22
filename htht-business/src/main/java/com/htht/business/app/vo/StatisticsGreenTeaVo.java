package com.htht.business.app.vo;

import lombok.Data;

/**
 * @projectName: htht
 * @package: com.htht.business.app.vo
 * @className: StatisticsGreenTeaVo
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/26 2:40
 * @version: 1.0
 */
@Data
public class StatisticsGreenTeaVo {
    /**
     * 一级茶青(总)
     */
    private Double firstLevelGreenTea;

    /**
     * 二级茶青(总)
     */
    private Double secondLevelGreenTea;
}
