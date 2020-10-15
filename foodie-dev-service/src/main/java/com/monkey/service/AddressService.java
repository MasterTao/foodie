package com.monkey.service;

import com.monkey.pojo.UserAddress;

import java.util.List;

/**
 * @author tao
 * @date 2020/10/9 9:39 下午
 */
public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     * @param userId
     * @return
     */
    List<UserAddress> queryAll(String userId);
}
