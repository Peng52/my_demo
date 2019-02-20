package com.jack.shiro.service;

import com.jack.shiro.entity.UserInfo;

/**
 * @description: 用户
 * @author: peng
 * @date: 2019-02-20
 **/
public interface UserInfoService {
    /**
    *根据用户名获取用户信息
    */
    UserInfo findByUserName(String userName);


}
