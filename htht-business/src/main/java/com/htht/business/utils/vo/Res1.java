package com.htht.business.utils.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @projectName: htht
 * @package: com.htht.business.utils.vo
 * @className: Res1
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/21 23:48
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Res1 {
    private String title;
    private String image;
    private String time;
    private String today;
    private Object info;
}
