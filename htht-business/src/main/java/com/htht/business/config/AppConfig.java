package com.htht.business.config;

import com.htht.business.config.properties.AppProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    AppProperties appProperties() {
        return new AppProperties();
    }

}
