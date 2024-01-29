package com.htht.business.thirty.camera.video;

import lombok.Data;

import java.util.List;

@Data
public class DeviceListDTO {
    private List<Device> data;
}

@Data
class Device{
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String deviceid;
    private String manufacturer;
    private String civilCode;
    private String status;
}
