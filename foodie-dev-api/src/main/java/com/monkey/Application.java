package com.monkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tao
 * @date 2020/10/7 3:19 下午
 */
@SpringBootApplication
// 扫描mybatis通用mapper所在的包
@MapperScan(basePackages = "com.monkey.mapper")
// 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.monkey", "org.n3r.idworker"})
@EnableOpenApi
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
