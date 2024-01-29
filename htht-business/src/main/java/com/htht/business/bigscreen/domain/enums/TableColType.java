package com.htht.business.bigscreen.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TableColType {

    NORMAL("0", "普通"),
    FILE("1", "文件类型");

    private final String code;
    private final String explain;

}
