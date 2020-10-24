package com.monkey.service.center;

import com.monkey.utils.PagedGridResult;

/**
 * @author tao
 * @date 2020/10/8 4:21 下午
 */
public interface MyOrdersService {

    /**
     * 查询我的订单列表
     * @param userId
     * @param orderStatus
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize);
}
