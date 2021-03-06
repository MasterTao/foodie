package com.monkey.service;

import com.monkey.pojo.OrderStatus;
import com.monkey.pojo.bo.SubmitOrderBO;
import com.monkey.pojo.vo.OrderVO;

/**
 * @author tao
 * @date 2020/10/19 8:31 下午
 */
public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /**
     * 修改订单状态
     * @param orderId
     * @param orderStatus
     */
    void updateOrderStatus(String orderId, Integer orderStatus);

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    OrderStatus queryOrderStatusInfo(String orderId);

    /**
     * 关闭超时未支付订单
     */
    void closeOrder();
}
