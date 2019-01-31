package com.jack.shiro.shiro_test;

import com.jack.shiro.ShiroApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author : peng
 * @Description : IniRealm
 * @Date : 2019-01-31 14:53
 */
@Slf4j
public class IniRealmTest extends ShiroApplicationTests {

    //shiro
    @Test
    public void test1(){
        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        //定义SecurityManager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        //SecurityManager中加入 Realm
        manager.setRealm(iniRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Jack","123456");
        subject.login(token);
        log.info("认证："+subject.isAuthenticated());
        subject.logout();
        log.info("认证："+subject.isAuthenticated());


    }


}
