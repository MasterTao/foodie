package com.monkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class BaseController {
    public static final Integer COMMENT_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 10;

}
