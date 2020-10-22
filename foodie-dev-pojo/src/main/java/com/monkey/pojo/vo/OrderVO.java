package com.monkey.pojo.vo;

import lombok.Data;

/**
 * @author tao
 * @date 2020/10/22 7:00 下午
 */
@Data
public class OrderVO {
    private String orderId;
    private MerchantOrdersVO merchantOrdersVO;
}
