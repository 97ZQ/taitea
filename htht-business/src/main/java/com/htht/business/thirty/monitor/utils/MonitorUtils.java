package com.htht.business.thirty.monitor.utils;

import com.htht.business.thirty.equip.utils.RestTemplateUtils;
import com.htht.common.exception.ServiceException;
import com.htht.common.utils.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.*;

@Slf4j
@Component
public class MonitorUtils {

    private static final String ACCESS_TOKEN_KEY = "cloud-access-token";
    private static final RestTemplate REST_TEMPLATE = RestTemplateUtils.build();

    @PostConstruct
    public void init() {
        updAccessToken();
    }

    public static String getAccessTokenFromRedis() {
        String accessToken = RedisUtils.getCacheObject(ACCESS_TOKEN_KEY);
        if (accessToken == null) {
            accessToken = updAccessToken();
        }
        if (accessToken == null) {
            throw new ServiceException("获取accessToken失败");
        }
        return accessToken;
    }

    private static String updAccessToken() {
        AccessTokenInfo accessToken = getAccessToken();
        if (accessToken == null) {
            throw new ServiceException("获取accessToken失败");
        }
        RedisUtils.setCacheObject(ACCESS_TOKEN_KEY, accessToken.getAccessToken(), Duration.ofHours(6 * 24 + 23));
        return accessToken.getAccessToken();
    }

    /**
     * 获取accessToken
     */
    private static AccessTokenInfo getAccessToken() {
        try {
            Map<String, List<String>> mapOf = new HashMap<>();
            mapOf.put("appKey", Collections.singletonList("019350e04b414842a400d2697ff6c27d"));
            mapOf.put("appSecret", Collections.singletonList("a47f6eb47d01e6addd40ee4cd56ed6f2"));
            RequestEntity<Map<String, List<String>>> requestEntity = RequestEntity
                .post("https://open.ys7.com/api/lapp/token/get")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(
                    CollectionUtils.toMultiValueMap(
                        mapOf
                    )
                );
            ResponseEntity<BaseResponse<AccessTokenInfo>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<BaseResponse<AccessTokenInfo>>() {
            });
            BaseResponse<AccessTokenInfo> body = response.getBody();
            if (body == null) {
                throw new ServiceException("获取accessToken失败：" + response.toString());
            }
            if (!"200".equals(body.getCode())) {
                throw new ServiceException("获取accessToken失败：" + response.toString());
            }
            return body.getData();
        } catch (Exception e) {

            log.error("获取accessToken失败：" + e.getMessage());
            return null;
        }
    }

    /**
     * 获取播放地址
     */
    public static VideoAddress getVideoAddress(String deviceSerial) {
        try {
            return getVideoAddress(getAccessTokenFromRedis(), deviceSerial);
        } catch (Exception e) {
            log.error("获取播放地址失败：" + e.getMessage());
            if (e instanceof ServiceException) {
                throw new ServiceException(e.getMessage());
            }
            throw new RuntimeException("获取播放地址失败");
        }
    }

    /**
     * 获取播放地址
     */
    private static VideoAddress getVideoAddress(String accessToken, String deviceSerial) {
        Map<String, List<String>> mapOf = new HashMap<>();
        mapOf.put("accessToken", Collections.singletonList(accessToken));
        mapOf.put("deviceSerial", Collections.singletonList(deviceSerial));
        RequestEntity<Map<String, List<String>>> requestEntity = RequestEntity
            .post("https://open.ys7.com/api/lapp/v2/live/address/get")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(
                CollectionUtils.toMultiValueMap(
                    mapOf
                )
            );
        ResponseEntity<BaseResponse<VideoAddress>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<BaseResponse<VideoAddress>>() {
        });
        BaseResponse<VideoAddress> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取播放地址失败：" + response.toString());
        }
        if (!"200".equals(body.getCode())) {
            throw new ServiceException("获取播放地址失败：" + body.getMsg());
        }
        return body.getData();
    }

    /**
     * 方向：操作命令：0-上，1-下，2-左，3-右，4-左上，5-左下，6-右上，7-右下，8-放大，9-缩小，10-近焦距，11-远焦距，16-自动控制
     */
    private static final List<Integer> DIRECTIONS = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 16);

    /**
     * 云台速度：0-慢，1-适中，2-快，海康设备参数不可为0
     */
    private static final List<Integer> SPEEDS = Arrays.asList(0, 1, 2);

    /**
     * 开启云台控制
     *
     * @param deviceSerial 摄像头序列号
     * @param direction    方向：操作命令：0-上，1-下，2-左，3-右，4-左上，5-左下，6-右上，7-右下，8-放大，9-缩小，10-近焦距，11-远焦距，16-自动控制
     * @param speed        云台速度：0-慢，1-适中，2-快，海康设备参数不可为0
     */
    public static String startControlCamera(String deviceSerial, int direction, int speed) {
        try {
            if (!DIRECTIONS.contains(direction)) {
                throw new ServiceException("方向不存在");
            }
            if (!SPEEDS.contains(speed)) {
                throw new ServiceException("云台速度不存在");
            }
            return startControlCamera(getAccessTokenFromRedis(), deviceSerial, 1, direction, speed);
        } catch (Exception e) {
            log.error("控制摄像头失败：" + e.getMessage());
            throw new ServiceException("控制摄像头失败");
        }
    }

    /**
     * 控制摄像头
     */
    private static String startControlCamera(String accessToken, String deviceSerial, int channelNo, int direction, int speed) {
        Map<String, List<Object>> mapOf = new HashMap<>();
        mapOf.put("accessToken", Collections.singletonList(accessToken));
        mapOf.put("deviceSerial", Collections.singletonList(deviceSerial));
        mapOf.put("channelNo", Collections.singletonList(channelNo));
        mapOf.put("direction", Collections.singletonList(direction));
        mapOf.put("speed", Collections.singletonList(speed));
        RequestEntity<Map<String, List<Object>>> requestEntity = RequestEntity
            .post("https://open.ys7.com/api/lapp/device/ptz/start")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(
                CollectionUtils.toMultiValueMap(
                    mapOf
                )
            );
        ResponseEntity<BaseResponse<Object>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<BaseResponse<Object>>() {
        });
        BaseResponse<Object> body = response.getBody();
        if (body == null) {
            throw new ServiceException("控制摄像头失败：" + response.toString());
        }
        if (!"200".equals(body.getCode())) {
            throw new ServiceException("控制摄像头失败：" + body.getMsg());
        }
        return body.getMsg();
    }

    /**
     * 停止云台控制
     *
     * @param deviceSerial 摄像头序列号
     */
    public static String stopControlCamera(String deviceSerial) {
        try {
            return stopControlCamera(getAccessTokenFromRedis(), deviceSerial, 1);
        } catch (Exception e) {
            log.error("控制摄像头失败：" + e.getMessage());
            throw new ServiceException("控制摄像头失败");
        }
    }

    /**
     * 停止控制摄像头
     */
    private static String stopControlCamera(String accessToken, String deviceSerial, int channelNo) {
        Map<String, List<Object>> mapOf = new HashMap<>();
        mapOf.put("accessToken", Collections.singletonList(accessToken));
        mapOf.put("deviceSerial", Collections.singletonList(deviceSerial));
        mapOf.put("channelNo", Collections.singletonList(channelNo));
        RequestEntity<Map<String, List<Object>>> requestEntity = RequestEntity
            .post("https://open.ys7.com/api/lapp/device/ptz/stop")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(
                CollectionUtils.toMultiValueMap(
                    mapOf
                )
            );
        ResponseEntity<BaseResponse<Object>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<BaseResponse<Object>>() {
        });
        BaseResponse<Object> body = response.getBody();
        if (body == null) {
            throw new ServiceException("停止控制摄像头失败：" + response.toString());
        }
        if (!"200".equals(body.getCode())) {
            throw new ServiceException("停止控制摄像头失败：" + body.getMsg());
        }
        return body.getMsg();
    }

}
