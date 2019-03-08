package com.jack.shiro.shiro_test;

import com.jack.shiro.ShiroApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * @author : peng
 * @Description : Shiro 测试类
 * @Date : 2019-01-31 14:00
 */
@Slf4j
public class ShiroTest extends ShiroApplicationTests {
    //shiro
    @Test
    public void test1(){
        //定义SecurityManager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        //SecurityManager中加入 Realm

        //主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Jack","123456");
        subject.login(token);
        log.info("认证："+subject.isAuthenticated());
        subject.checkRole("admin");
        subject.logout();
        log.info("认证："+subject.isAuthenticated());

    }

    //测试
    @Test
    public void test9(){
        //test #1

        //test #2

        //test #3

        //test #4

        //test #5

        //test #6
    }







}
