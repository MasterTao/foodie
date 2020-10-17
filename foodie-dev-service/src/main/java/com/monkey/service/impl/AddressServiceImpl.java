package com.monkey.service.impl;

import com.monkey.mapper.UserAddressMapper;
import com.monkey.pojo.UserAddress;
import com.monkey.pojo.bo.AddressBO;
import com.monkey.service.AddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/15 9:01 下午
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    @Resource
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return userAddressMapper.select(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {
        // 1. 判断当前用户是否存在地址，如果没有，则新增为默认地址
        Integer isDefault = 0;
        List<UserAddress> userAddresses = queryAll(addressBO.getUserId());
        if (userAddresses == null || userAddresses.isEmpty()) {
            isDefault = 1;
        }

        String addressId = sid.nextShort();

        // 2. 保存地址到数据库
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO, userAddress);

        userAddress.setId(addressId);
        userAddress.setIsDefault(isDefault);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(userAddress.getCreatedTime());

        userAddressMapper.insert(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();

        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressBO, userAddress);

        userAddress.setId(addressId);
        userAddress.setUpdatedTime(new Date());

        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteUserAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);

        userAddressMapper.delete(userAddress);
    }
}
