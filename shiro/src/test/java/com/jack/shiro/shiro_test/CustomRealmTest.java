package com.jack.shiro.shiro_test;

import com.jack.shiro.ShiroApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        subject.login(token);
        log.info("认证："+subject.isAuthenticated());
      /*  subject.checkRole("admin");
        subject.logout();
        log.info("认证："+subject.isAuthenticated());*/

    }


    //md5 + salt 生成
    @Test
    public void test2(){
        Md5Hash md5Hash = new Md5Hash("123456","admin");
        System.out.println(md5Hash.toString());

    }




}
