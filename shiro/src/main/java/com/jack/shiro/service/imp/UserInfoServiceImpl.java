package com.jack.shiro.service.imp;

import com.jack.shiro.dao.UserInfoRepository;
import com.jack.shiro.entity.UserInfo;
import com.jack.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户信息
 * @author: peng
 * @date: 2019-02-20
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUserName(String userName) {
        return userInfoRepository.findByUserName(userName);
    }
}
