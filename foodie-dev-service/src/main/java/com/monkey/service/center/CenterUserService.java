package com.monkey.service.center;

import com.monkey.pojo.Users;
import com.monkey.pojo.bo.center.CenterUserBO;

/**
 * @author tao
 * @date 2020/10/8 4:21 下午
 */
public interface CenterUserService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    Users queryUserInfo(String userId);

    /**
     * 修改用户信息
     * @param userId
     * @param centerUserBO
     * @return
     */
    Users updateUserInfo(String userId, CenterUserBO centerUserBO);

    /**
     * 用户头像更新
     * @param userId
     * @param faceUrl
     * @return
     */
    Users updateUserFace(String userId, String faceUrl);
}
