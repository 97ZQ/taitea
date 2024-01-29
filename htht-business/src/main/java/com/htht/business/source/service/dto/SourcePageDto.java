package com.htht.business.source.service.dto;

import com.htht.common.core.domain.PageQuery;
import lombok.Data;

@Data
public class SourcePageDto extends PageQuery {

    /**
     * 商品名称
     */
    private String name;

}
