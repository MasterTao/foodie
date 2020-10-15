package com.monkey.service.impl;

import com.monkey.mapper.UserAddressMapper;
import com.monkey.pojo.UserAddress;
import com.monkey.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/15 9:01 下午
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return userAddressMapper.select(userAddress);
    }
}
