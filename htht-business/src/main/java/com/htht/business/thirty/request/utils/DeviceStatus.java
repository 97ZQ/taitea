package com.htht.business.thirty.request.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DeviceStatus {

    ONLINE(0, ""),
    OFFLINE(1, "");

    private final int code;
    private final String explain;

}
