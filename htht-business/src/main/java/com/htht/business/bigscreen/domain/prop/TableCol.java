package com.htht.business.bigscreen.domain.prop;

import lombok.Getter;
import lombok.Setter;

/**
 * 表头（列）信息
 */
@Getter
@Setter
public class TableCol {

    /**
     * 列顺序
     */
    private Integer seq;

    /**
     * 列的key（同一个表中唯一）
     */
    private String key;

    /**
     * 列名称
     */
    private String name;

    /**
     * 列的其他信息，由前端自定义
     */
    private Object frontProp;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof TableCol)) {
            return false;
        } else if (this != obj) {
            return false;
        } else return this.getKey().equals(((TableCol) obj).getKey());
    }
}
