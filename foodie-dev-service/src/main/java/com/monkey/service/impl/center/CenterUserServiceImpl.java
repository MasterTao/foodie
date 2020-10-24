package com.monkey.service.impl.center;

import com.monkey.mapper.UsersMapper;
import com.monkey.pojo.Users;
import com.monkey.pojo.bo.center.CenterUserBO;
import com.monkey.service.center.CenterUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author tao
 * @date 2020/10/23 4:54 下午
 */
@Service
public class CenterUserServiceImpl implements CenterUserService {

    @Resource
    private UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public Users queryUserInfo(String userId) {
        Users queryUser = new Users();
        queryUser.setId(userId);
        Users user = usersMapper.selectOne(queryUser);
        user.setPassword(null);
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Users updateUserInfo(String userId, CenterUserBO centerUserBO) {
        Users updateUser = new Users();
        BeanUtils.copyProperties(centerUserBO, updateUser);

        updateUser.setId(userId);
        updateUser.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKeySelective(updateUser);

        return queryUserInfo(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Users updateUserFace(String userId, String faceUrl) {

        Users updateUser = new Users();

        updateUser.setId(userId);
        updateUser.setFace(faceUrl);
        updateUser.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKeySelective(updateUser);

        return queryUserInfo(userId);
    }
}
