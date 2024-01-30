package com.htht.business.thirty.monitor.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.thirty.monitor.utils.MonitorUtils;
import com.htht.common.core.domain.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 监控
 */
@SaIgnore
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    /**
     * 获取accessToken
     */
    @GetMapping("/getAccessToken")
    public R getAccessToken() {
        R<String> ok = R.ok();
        ok.setData(
            MonitorUtils.getAccessTokenFromRedis()
        );
        return ok;
    }

    /**
     * 获取播放地址
     */
    @GetMapping("/getVideoAddress")
    public R getAccessToken(String deviceSerial) {
        return R.ok(
            MonitorUtils.getVideoAddress(deviceSerial)
        );
    }

    /**
     * 云台控制
     *
     * @param deviceSerial 摄像头序列号
     * @param direction    方向：操作命令：0-上，1-下，2-左，3-右，4-左上，5-左下，6-右上，7-右下，8-放大，9-缩小，10-近焦距，11-远焦距，16-自动控制
     * @param speed        云台速度：0-慢，1-适中，2-快，海康设备参数不可为0
     */
    @GetMapping("/controlCamera")
    public R controlCamera(String deviceSerial, int direction, int speed) {
        return R.ok(
            MonitorUtils.controlCamera(deviceSerial, direction, speed)
        );
    }

}
