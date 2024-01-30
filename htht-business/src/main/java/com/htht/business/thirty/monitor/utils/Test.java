package com.htht.business.thirty.monitor.utils;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        DefaultUriBuilderFactory uriFactory = new DefaultUriBuilderFactory("http://www.farm-iot.cn:8089");
        uriFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);  // for backwards compatibility..

        restTemplate.setUriTemplateHandler(uriFactory);
        ResponseEntity<String> forEntity = restTemplate.getForEntity("/api/Soil/DevStatus", String.class);
//        restTemplate.setErrorHandler();
//        restTemplate.setInterceptors();
        System.out.println();
    }

    class A implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            return null;
        }

    }

}
