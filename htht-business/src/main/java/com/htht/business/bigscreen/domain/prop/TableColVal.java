package com.htht.business.bigscreen.domain.prop;

import lombok.Data;

@Data
public class TableColVal {

    /**
     * 列的key（对应{@link TableCol}）
     */
    private String key;

    /**
     * 列的值
     */
    private Object val;

}
