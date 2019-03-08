package com.jack.shiro.controller;

import com.jack.shiro.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Shiro - 用户登陆权限管理
 * @author: peng
 * @date: 2019-02-23
 **/
@RestController
public class ContrllerShiro {

    @ResponseBody
    @PostMapping("/login")
    public String login(UserInfo userInfo){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(),userInfo.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
           return e.getMessage();
        }
        return "Success";

    }





}
