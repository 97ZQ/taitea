package com.htht.business.thirty.equip.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.htht.business.thirty.equip.utils.ThirdEquipUtils;
import com.htht.common.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;

/**
 * 第三方设备
 */
@SaIgnore
@Slf4j
@RestController
@RequestMapping("/thirdEquip")
public class ThirdEquipController {
    /**
     * 获取农场列表
     *
     * @param page     页数
     * @param pageSize 数量
     */
    @GetMapping("/getFarmList")
    public R getFarmList(int page, int pageSize) {
        try {
            return R.ok(ThirdEquipUtils.getFarmList(page, pageSize));
        } catch (HttpClientErrorException.Unauthorized e) {
            ThirdEquipUtils.updateAuthCode();
            return R.ok(ThirdEquipUtils.getFarmList(page, pageSize));
        } catch (Exception e) {
            log.error("请求错误：" + e.getMessage());
            throw new RuntimeException("请求错误");
        }
    }

    /**
     * 获取设备列表
     *
     * @param farmId  农场id
     * @param devType 设备类型，0：获取全部
     */
    @GetMapping("/getDeviceList")
    public R getDeviceList(long farmId, int devType) {
        try {
            return R.ok(ThirdEquipUtils.getDeviceList(farmId, devType));
        } catch (HttpClientErrorException.Unauthorized e) {
            ThirdEquipUtils.updateAuthCode();
            return R.ok(ThirdEquipUtils.getDeviceList(farmId, devType));
        } catch (Exception e) {
            log.error("请求错误：" + e.getMessage());
            throw new RuntimeException("请求错误");
        }
    }

    /**
     * 获取设备传感器数据
     *
     * @param devId 设备id
     */
    @GetMapping("/getDeviceData")
    public R getDeviceData(long devId) {
        try {
            return R.ok(ThirdEquipUtils.getDeviceData(devId));
        } catch (HttpClientErrorException.Unauthorized e) {
            ThirdEquipUtils.updateAuthCode();
            return R.ok(ThirdEquipUtils.getDeviceData(devId));
        } catch (Exception e) {
            log.error("请求错误：" + e.getMessage());
            throw new RuntimeException("请求错误");
        }
    }

    /**
     * 获取管式土壤墒情仪数据
     *
     * @param devId 设备id
     */
    @GetMapping("/getSoilDeviceData")
    public R getSoilDeviceData(long devId) {
        try {
            return R.ok(ThirdEquipUtils.getSoilDeviceData(devId));
        } catch (HttpClientErrorException.Unauthorized e) {
            ThirdEquipUtils.updateAuthCode();
            return R.ok(ThirdEquipUtils.getSoilDeviceData(devId));
        } catch (Exception e) {
            log.error("请求错误：" + e.getMessage());
            throw new RuntimeException("请求错误");
        }
    }

    /**
     * 获取虫情运行记录
     *
     * @param devId     设备id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param page      页数
     * @param pageSize  页量
     */
    @GetMapping("/getInsectRecord")
    public R getSoilDeviceData(long devId, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime, int page, int pageSize) {
        try {
            return R.ok(ThirdEquipUtils.getInsectRecord(devId, startTime, endTime, page, pageSize));
        } catch (HttpClientErrorException.Unauthorized e) {
            ThirdEquipUtils.updateAuthCode();
            return R.ok(ThirdEquipUtils.getInsectRecord(devId, startTime, endTime, page, pageSize));
        } catch (Exception e) {
            log.error("请求错误：" + e.getMessage());
            throw new RuntimeException("请求错误");
        }
    }

}
