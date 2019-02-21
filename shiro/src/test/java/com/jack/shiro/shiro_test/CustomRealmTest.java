package com.jack.shiro.shiro_test;

import com.jack.shiro.ShiroApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : peng
 * @Description : CustomsRealm 自定义测试
 * @Date : 2019-02-21 17:07
 */
@Slf4j
public class CustomRealmTest extends ShiroApplicationTests {

    @Autowired
    private SecurityManager securityManager;

    //
    @Test
    public void test1(){

        //主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "d3c59d25033dbf980d29554025c23a75");
        subject.login(token);
        log.info("认证："+subject.isAuthenticated());
        subject.checkRole("admin");
        subject.logout();
        log.info("认证："+subject.isAuthenticated());

    }




}