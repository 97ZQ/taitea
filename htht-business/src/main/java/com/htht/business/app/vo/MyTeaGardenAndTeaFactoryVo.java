package com.htht.business.app.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.htht.business.app.domain.AppDbMyTeaFactory;
import com.htht.business.app.domain.AppDbMyTeaGarden;
import lombok.Data;

import java.util.List;

/**
 * @projectName: htht
 * @package: com.htht.business.app.vo
 * @className: MyTeaGardenAndTeaFactory
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/3/24 17:21
 * @version: 1.0
 */
@Data
public class MyTeaGardenAndTeaFactoryVo {
    /**
     * 我的茶园
     */
    private List<AppDbMyTeaGarden> appDbMyTeaGardenList;

    /**
     * 我的茶厂
     */
    private List<AppDbMyTeaFactory> appDbMyTeaFactoryList;
}
