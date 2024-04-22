package com.htht.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @projectName: htht
 * @package: com.htht.test
 * @className: ZhangWeiTest
 * @author: zhangwei
 * @description: TODO
 * @date: 2024/4/1 16:26
 * @version: 1.0
 */
public class ZhangWeiTest {

    @Tag("test")
    @DisplayName("测试 @Tag test")
    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        int year = 2023;
        int month = 4;
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month); // 注意：月份是从0开始的
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

//        int day = i - 1;

        List<String> historyDateList = new ArrayList<>();
        for (int j = 1; j <= i; j++) {
            System.out.println("j = " + j);
            System.out.println(year + "-" + month + "-" + j);
            historyDateList.add(year + "-" + month + "-" + j);
        }
    }
}
