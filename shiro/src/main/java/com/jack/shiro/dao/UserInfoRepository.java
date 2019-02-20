package com.jack.shiro.dao;

import com.jack.shiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 用户身份认证
 * @author: peng
 * @date: 2019-02-20
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    /**
    *根据用户查找用户信息
    */
    UserInfo findByUserName(String userName);


}
