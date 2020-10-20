package com.monkey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author tao
 * @date 2020/10/9 1:06 下午
 */
//@Configuration
public class CorsConfig {

    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        //config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("*");

        // 设置是否发送cookie信息
        config.setAllowCredentials(true);

        // 设置允许请求的方式
        // config.setAllowedMethods();

        // 设置允许的header
        config.addAllowedHeader("*");

        config.setAllowCredentials(true);

        // 2. 为url添加映射路径
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", config);

        // 3. 返回重新定义好的urlBasedCorsConfigurationSource
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
