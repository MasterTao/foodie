package com.monkey.service;

import com.monkey.pojo.bo.SubmitOrderBO;

/**
 * @author tao
 * @date 2020/10/19 8:31 下午
 */
public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    void createOrder(SubmitOrderBO submitOrderBO);
}