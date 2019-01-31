package com.jack.shiro.shiro_test;

import com.alibaba.druid.pool.DruidDataSource;
import com.jack.shiro.ShiroApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 * @author : peng
 * @Description : JdbcRealm
 * @Date : 2019-01-31 16:45
 */
@Slf4j
public class JdbcRealmTest extends ShiroApplicationTests {

    //shiro
    @Test
    public void test1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&userSSL=false&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcRealm realm = new JdbcRealm();
        //自定义的身份认证 SQL查询
        String sql = "select password from users  where username = ?";
        realm.setAuthenticationQuery(sql);
        //自定义 角色认证 SQL查询
        String roleSql = "select role_name from user_roles where username = ?";
        realm.setUserRolesQuery(roleSql);
        realm.setDataSource(dataSource);
        //定义SecurityManager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        //SecurityManager中加入 Realm
        manager.setRealm(realm);
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





}
