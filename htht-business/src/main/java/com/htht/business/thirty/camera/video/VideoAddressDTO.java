package com.htht.business.thirty.camera.video;

import lombok.Data;

import java.util.List;

@Data
public class VideoAddressDTO {
    private List<Address> data;
}

@Data
class Address{
    private String rtmp;
    private String rtmp_wan;
    private String ws_flv;
    private String ws_flv_wan;
    private String http_flv;
    private String http_flv_wan;
    private String deviceId;
    private String streamId;
}
