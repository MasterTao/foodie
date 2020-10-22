package com.monkey.pojo.vo;

import lombok.Data;

/**
 * @author tao
 * @date 2020/10/22 7:00 下午
 */
@Data
public class MerchantOrdersVO {
    private String merchantOrderId;
    private String merchantUserId;
    private Integer amount;
    private Integer payMethod;
    private String returnUrl;
}
