package com.monkey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@ApiIgnore
@RestController
public class HelloController {

    static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Object hello() {

        logger.debug("info: hello~");
        logger.info("info: hello~");
        logger.warn("info: hello~");
        logger.error("info: hello~");

        return "Hello World~";
    }
}
