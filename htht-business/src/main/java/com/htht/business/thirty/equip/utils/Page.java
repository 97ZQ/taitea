package com.htht.business.thirty.equip.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    /**
     * 记录数
     */
    private Integer records;

    /**
     * 第几页
     */
    private Integer page;

    /**
     * 每页的记录数量
     */
    @JsonAlias("pagesize")
    private Integer pageSize;

    /**
     * 总共的数量
     */
    private Integer total;

    /**
     * 数据
     */
    private List<T> rows;

}
