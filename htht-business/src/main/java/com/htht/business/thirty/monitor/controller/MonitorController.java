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
     * 开启云台控制
     * 对设备进行开始云台控制，开始云台控制之后必须先调用停止云台控制接口才能进行其他操作，包括其他方向的云台转动
     *
     * @param deviceSerial 摄像头序列号
     * @param direction    方向：操作命令：0-上，1-下，2-左，3-右，4-左上，5-左下，6-右上，7-右下，8-放大，9-缩小，10-近焦距，11-远焦距，16-自动控制
     * @param speed        云台速度：0-慢，1-适中，2-快，海康设备参数不可为0
     */
    @GetMapping("/startControlCamera")
    public R startControlCamera(String deviceSerial, int direction, int speed) {
        return R.ok(
            MonitorUtils.startControlCamera(deviceSerial, direction, speed)
        );
    }

    /**
     * 停止云台控制
     *
     * @param deviceSerial 摄像头序列号
     */
    @GetMapping("/stopControlCamera")
    public R stopControlCamera(String deviceSerial) {
        return R.ok(
            MonitorUtils.stopControlCamera(deviceSerial)
        );
    }

}
