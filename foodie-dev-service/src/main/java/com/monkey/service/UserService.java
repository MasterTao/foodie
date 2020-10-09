package com.monkey.service;

import com.monkey.pojo.Users;
import com.monkey.pojo.bo.UserBO;

/**
 * @author tao
 * @date 2020/10/8 4:21 下午
 */
public interface UserService {

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 用户名是否存在
     */
    boolean queryUserNameIsExist(String username);

    /**
     * 创建用户
     * @param userBO 创建用户数据
     * @return 用户信息
     */
    Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登陆
     *
     * @param username
     * @param password
     * @return
     */
    Users queryUserForLogin(String username, String password);
}
