package com.htht.business.thirty.equip.utils;

import com.htht.common.exception.ServiceException;
import com.htht.common.utils.DateUtils;
import com.htht.common.utils.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第三方设备登录工具
 */
@Slf4j
@Component
public class ThirdEquipUtils {

    private static final RestTemplate REST_TEMPLATE = RestTemplateUtils.build();

    private static final String AUTH_CODE_KEY = "third-equip-auth-code";

    @PostConstruct
    public void init() {
        updateAuthCode();
    }

    public static String getAuthCode() {
        LoginInfo loginInfo = RedisUtils.getCacheObject(AUTH_CODE_KEY);
        if (loginInfo != null) {
            return loginInfo.getAuthCode();
        }
        return updateAuthCode().getAuthCode();
    }

    public static LoginInfo updateAuthCode() {
        LoginInfo loginInfo = ThirdEquipUtils.getLoginInfo();
        if (loginInfo == null) {
            throw new RuntimeException("获取authCode失败");
        }
        RedisUtils.setCacheObject(AUTH_CODE_KEY, loginInfo);
        return loginInfo;
    }

    public static LoginInfo getLoginInfo() {
        Map<String, String> mapOf = new HashMap<>();
        mapOf.put("Username", "tscy");
        mapOf.put("Password", "123456");
        RequestEntity<Map<String, String>> requestEntity = RequestEntity
            .post("http://www.farm-iot.cn:8089/api/Account/Login")
            .body(mapOf
            );
        ResponseEntity<CommonResponse<LoginInfo>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<CommonResponse<LoginInfo>>() {
        });
        CommonResponse<LoginInfo> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取登录信息失败：" + response.toString());
        }
        return body.getData();
    }

    /**
     * 获取农场列表
     */
    public static Page<Farm> getFarmList(int pageIndex, int pageSize) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl("http://www.farm-iot.cn:8089/api/Farm/FarmList")
            .queryParam("AuthCode", getAuthCode())
            .queryParam("pageIndex", String.valueOf(pageIndex))
            .queryParam("pageSize", String.valueOf(pageSize))
            .toUriString();
        RequestEntity<Void> requestEntity = RequestEntity
            .get(uriString)
            .build();
        ResponseEntity<CommonResponse<Page<Farm>>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<CommonResponse<Page<Farm>>>() {
        });
        CommonResponse<Page<Farm>> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取农场列表失败：" + response.toString());
        }
        return body.getData();
    }

    /**
     * 获取设备列表
     */
    public static List<Device> getDeviceList(long farmId, int devType) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl("http://www.farm-iot.cn:8089/api/DevManage/GetDeviceList")
            .queryParam("AuthCode", getAuthCode())
            .queryParam("devType", devType)
            .queryParam("farmId", farmId)
            .toUriString();
        RequestEntity<Void> requestEntity = RequestEntity
            .get(uriString)
            .build();
        ResponseEntity<CommonResponse<List<Device>>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<CommonResponse<List<Device>>>() {
        });
        CommonResponse<List<Device>> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取设备列表失败");
        }
        return body.getData();
    }


    /**
     * 获取设备传感器数据
     */
    public static List<DeviceSensor> getDeviceData(long devId) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl("http://www.farm-iot.cn:8089/api/Data/GetAllData")
            .queryParam("AuthCode", getAuthCode())
            .queryParam("devId", devId)
            .toUriString();
        RequestEntity<Void> requestEntity = RequestEntity
            .get(uriString)
            .build();
        ResponseEntity<CommonResponse<List<DeviceSensor>>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<CommonResponse<List<DeviceSensor>>>() {
        });
        CommonResponse<List<DeviceSensor>> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取设备传感器数据失败：" + response.toString());
        }
        return body.getData();
    }

    /**
     * 获取管式土壤墒情仪数据
     */
    public static SoilDevice getSoilDeviceData(long deviceId) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl("http://www.farm-iot.cn:8089/api/Soil/DevStatus")
            .queryParam("AuthCode", getAuthCode())
            .queryParam("deviceId", deviceId)
            .toUriString();
        RequestEntity<Void> requestEntity = RequestEntity
            .get(uriString)
            .build();
        ResponseEntity<CommonResponse<SoilDevice>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<CommonResponse<SoilDevice>>() {
        });
        CommonResponse<SoilDevice> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取管式土壤墒情仪数据失败：" + response.toString());
        }
        return body.getData();
    }

    /**
     * 获取虫情运行记录
     */
    public static Page<InsectRecord> getInsectRecord(long devId, Date startTime, Date endTime, int page, int pageSize) {
        String uriString = UriComponentsBuilder
            .fromHttpUrl("http://www.farm-iot.cn:8089/api/Insect/GetRunRecord")
            .queryParam("AuthCode", getAuthCode())
            .toUriString();
        Map<String, Object> mapOf = new HashMap<>();
        mapOf.put("deviceId", devId);
        mapOf.put("startTime", DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", startTime));
        mapOf.put("endTime", DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", endTime));
        mapOf.put("page", page);
        mapOf.put("pageSize", pageSize);
        RequestEntity<Map<String, Object>> requestEntity = RequestEntity
            .post(uriString)
            .body(mapOf);
        ResponseEntity<CommonResponse<Page<InsectRecord>>> response = REST_TEMPLATE.exchange(requestEntity, new ParameterizedTypeReference<CommonResponse<Page<InsectRecord>>>() {
        });
        CommonResponse<Page<InsectRecord>> body = response.getBody();
        if (body == null) {
            throw new ServiceException("获取虫情运行记录失败：" + response.toString());
        }
        return body.getData();
    }

//    private RestTemplate build() {
//        RestTemplate restTemplate = new RestTemplate();
//        DefaultUriBuilderFactory uriFactory = new DefaultUriBuilderFactory("http://www.farm-iot.cn:8089");
//        uriFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);  // for backwards compatibility..
//        restTemplate.setUriTemplateHandler(uriFactory);
//        return restTemplate;
//    }

}
