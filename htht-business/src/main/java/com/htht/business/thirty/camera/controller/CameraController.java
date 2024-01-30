package com.htht.business.thirty.camera.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.thirty.camera.video.DeviceListDTO;
import com.htht.business.thirty.camera.video.VideoAddressDTO;
import com.htht.business.thirty.camera.video.VideoUtil;
import com.htht.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 摄像头
 */
@SaIgnore
//@RestController
@RequestMapping("/third/video")
@RequiredArgsConstructor
public class CameraController {

    /**
     * 获取视频设备列表
     */
    @GetMapping("/deviceList")
    public R getVideoDeviceList() throws NoSuchAlgorithmException, InvalidKeyException {
        DeviceListDTO deviceList = VideoUtil.getDeviceList();
        return R.ok(deviceList);
    }

    /**
     * 根据设备id获取视频地址
     *
     * @param deviceId 设备id
     */
    @GetMapping
    public R getVideo(String deviceId) throws NoSuchAlgorithmException, InvalidKeyException {
        VideoAddressDTO realTimeVideo = VideoUtil.getRealTimeVideo(deviceId);
        return R.ok(realTimeVideo);
    }

    /**
     * 根据设备id cmd 控制设备旋转
     *
     * @param deviceId 设备id
     * @param cmd      cmd类型 向左：1  向右：2  向上：3  向下：4  左上: 5  左下: 6  右上: 7   右下: 8
     */
    @GetMapping("/rotate")
    public R controlDeviceRotate(String deviceId, String cmd) throws NoSuchAlgorithmException, InvalidKeyException {
        return R.ok(
            VideoUtil.controlDeviceRotate(deviceId, cmd)
        );
    }

    /**
     * 根据设备id cmd 控制设备光圈
     *
     * @param deviceId 设备id
     * @param cmd      cmd 放大：1  缩小：2  光圈放大: 3  光圈缩小：4  聚焦远：5  聚焦近：6
     */
    @GetMapping("/aperture")
    public R controlDeviceAperture(String deviceId, String cmd) throws NoSuchAlgorithmException, InvalidKeyException {
        return R.ok(
            VideoUtil.controlDeviceAperture(deviceId, cmd)
        );
    }

    /**
     * 根据设备id启动设备
     *
     * @param deviceId 设备id
     */
    @GetMapping("/start")
    public R controlDeviceStart(String deviceId) throws NoSuchAlgorithmException, InvalidKeyException {
        return R.ok(
            VideoUtil.controlDeviceStart(deviceId)
        );
    }

    /**
     * 根据streamId视频流转码
     *
     * @param streamId
     */
    @GetMapping("/transcode")
    public R videoStreamTranscode(String streamId) throws NoSuchAlgorithmException, InvalidKeyException {
        return R.ok(
            VideoUtil.videoStreamTranscode(streamId)
        );
    }

}
