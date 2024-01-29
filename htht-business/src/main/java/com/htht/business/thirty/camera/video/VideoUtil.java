package com.htht.business.thirty.camera.video;

import cn.hutool.core.date.DateUtil;
import com.htht.common.utils.JsonUtils;
import com.htht.common.utils.OkHttpUtils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class VideoUtil {
    static String appKey = "gdxskj";
    static String appSecret = "cf84ff74747b41339119c23c7cca0faf";
    static String baseUrl = "https://tianyvideo.com";

    //设备列表
    public static DeviceListDTO getDeviceList() throws NoSuchAlgorithmException, InvalidKeyException {
        String url = baseUrl + "/device/api/videoClient/deviceList";
        String timestamp = DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss");
        String nonce = SignatureHelper.nonce();
        String result = OkHttpUtils.builder()
            .url(url)
            .addHeader("appKey", appKey)
            .addHeader("appSecret", appSecret)
            .addHeader("timestamp", timestamp)
            .addHeader("nonce", nonce)
            .addHeader("sign", SignatureHelper.token(appKey, appSecret, timestamp, nonce, null))
            .get()
            .sync();
        return JsonUtils.parseObject(result, DeviceListDTO.class);
    }

    //获取实时视频
    public static VideoAddressDTO getRealTimeVideo(String deviceId) throws NoSuchAlgorithmException, InvalidKeyException {
        String url = baseUrl + "/device/api/videoClient/startPlay";
        String timestamp = DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss");
        String nonce = SignatureHelper.nonce();
        Map<String, Object> requestParamsMap = new HashMap<>();
        requestParamsMap.put("deviceId", deviceId);
        requestParamsMap.put("tag", "123456");
        requestParamsMap.put("ifDealUrl", "true");
        String result = OkHttpUtils.builder()
            .url(url)
            .addParam("deviceId", deviceId)
            .addParam("tag", "123456")
            .addParam("ifDealUrl", "true")
            .addHeader("appKey", appKey)
            .addHeader("appSecret", appSecret)
            .addHeader("timestamp", timestamp)
            .addHeader("nonce", nonce)
            .addHeader("sign", SignatureHelper.token(appKey, appSecret, timestamp, nonce, requestParamsMap))
            .get()
            .sync();
        VideoAddressDTO videoAddressDTO = JsonUtils.parseObject(result, VideoAddressDTO.class);
        videoAddressDTO.getData().get(0).setStreamId(videoAddressDTO.getData().get(0).getHttp_flv_wan().substring(33, 74));
        return videoAddressDTO;
    }

    //控制设备旋转
    public static String controlDeviceRotate(String deviceId, String cmd) throws NoSuchAlgorithmException, InvalidKeyException {
        String url = baseUrl + "/device/api/videoClient/controlDirect";
        String timestamp = DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss");
        String nonce = SignatureHelper.nonce();
        Map<String, Object> requestParamsMap = new HashMap<>();
        /*
        cmd 控制命令：控制命令类型
        向左：1  向右：2  向上：3  向下：4  左上: 5  左下: 6  右上: 7   右下: 8
        */
        requestParamsMap.put("cmd", cmd);
        requestParamsMap.put("deviceId", deviceId);
        //speed
        requestParamsMap.put("speed", "1");
        return OkHttpUtils.builder()
            .url(url)
            .addParam("cmd", cmd)
            .addParam("deviceId", deviceId)
            .addParam("speed", "1")
            .addHeader("appKey", appKey)
            .addHeader("appSecret", appSecret)
            .addHeader("timestamp", timestamp)
            .addHeader("nonce", nonce)
            .addHeader("sign", SignatureHelper.token(appKey, appSecret, timestamp, nonce, requestParamsMap))
            .get()
            .sync();
    }

    //控制设备旋转
    public static String controlDeviceAperture(String deviceId, String cmd) throws NoSuchAlgorithmException, InvalidKeyException {
        String url = baseUrl + "/device/api/videoClient/controlZoom";
        String timestamp = DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss");
        String nonce = SignatureHelper.nonce();
        Map<String, Object> requestParamsMap = new HashMap<>();
        /*
        cmd 控制命令类型
        放大：1  缩小：2  光圈放大: 3  光圈缩小：4  聚焦远：5  聚焦近：6
        */
        requestParamsMap.put("cmd", cmd);
        requestParamsMap.put("deviceId", deviceId);
        //speed
        requestParamsMap.put("speed", "1");
        return OkHttpUtils.builder()
            .url(url)
            .addParam("cmd", cmd)
            .addParam("deviceId", deviceId)
            .addParam("speed", "1")
            .addHeader("appKey", appKey)
            .addHeader("appSecret", appSecret)
            .addHeader("timestamp", timestamp)
            .addHeader("nonce", nonce)
            .addHeader("sign", SignatureHelper.token(appKey, appSecret, timestamp, nonce, requestParamsMap))
            .get()
            .sync();
    }

    //根据设备id控制设备启动
    public static String controlDeviceStart(String deviceId) throws NoSuchAlgorithmException, InvalidKeyException {
        String url = baseUrl + "/device/api/videoClient/remoteStart";
        String timestamp = DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss");
        String nonce = SignatureHelper.nonce();
        Map<String, Object> requestParamsMap = new HashMap<>();
        requestParamsMap.put("devCode", deviceId);
        return OkHttpUtils.builder()
            .url(url)
            .addParam("devCode", deviceId)
            .addHeader("appKey", appKey)
            .addHeader("appSecret", appSecret)
            .addHeader("timestamp", timestamp)
            .addHeader("nonce", nonce)
            .addHeader("sign", SignatureHelper.token(appKey, appSecret, timestamp, nonce, requestParamsMap))
            .get()
            .sync();
    }

    //根据streamId视频流转码 h264
    public static VideoAddressDTO videoStreamTranscode(String streamId) throws NoSuchAlgorithmException, InvalidKeyException {
        String url = baseUrl + "/device/api/videoClient/convert";
        String timestamp = DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss");
        String nonce = SignatureHelper.nonce();
        Map<String, Object> requestParamsMap = new HashMap<>();
        requestParamsMap.put("streamId", streamId);
        String result = OkHttpUtils.builder()
            .url(url)
            .addParam("streamId", streamId)
            .addHeader("appKey", appKey)
            .addHeader("appSecret", appSecret)
            .addHeader("timestamp", timestamp)
            .addHeader("nonce", nonce)
            .addHeader("sign", SignatureHelper.token(appKey, appSecret, timestamp, nonce, requestParamsMap))
            .get()
            .sync();
        return JsonUtils.parseObject(result, VideoAddressDTO.class);
    }


}
