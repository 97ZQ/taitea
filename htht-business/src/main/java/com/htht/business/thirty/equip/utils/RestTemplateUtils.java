package com.htht.business.thirty.equip.utils;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtils {

    public static ClientHttpRequestFactory defaultFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(11000);
        return factory;
    }

    /**
     * 创建默认RestTemplate
     *
     * @return RestTemplate
     */
    public static RestTemplate build() {
        return build(defaultFactory());
    }

    /**
     * 读取默认配置，创建默认RestTemplate
     *
     * @return RestTemplate
     */
    public static RestTemplate build(ClientHttpRequestFactory requestFactory) {
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

}
