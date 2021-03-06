package com.monkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.File;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class BaseController {
    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 10;

    public static final String FOODIE_SHOP_CART = "shopcart";

    /**
     * 支付中心的调用地址
     */
    public static final String PAYMENT_URL = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";

    /**
     * 回调通知的url
     * 微信支付成功 -> 支付中心 -> 天天吃货平台
     */
    public static final String PAY_RETURN_URL = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    /**
     * 用户上传头像的位置
     */
    public static final String IMAGE_USER_FACE_LOCATION = File.separator + "Users" +
            File.separator + "tao" +
            File.separator + "WorkSpace" +
            File.separator + "JavaProject" +
            File.separator + "foodie-dev" +
            File.separator + "images" +
            File.separator + "faces";

}
