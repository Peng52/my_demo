package com.jack.shiro.config;

import com.jack.shiro.realm.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : peng
 * @Description : shiro配置
 * @Date : 2019-02-21 15:36
 */
@Configuration
public class ShiroConfig {

    /**
    *管理器
    */
    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getCustomRealm());
        return securityManager;
    }
    /**
    *自定义的Realm
    */
    @Bean("myRealm")
    public CustomRealm getCustomRealm(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        CustomRealm realm = new CustomRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }
    /**
    *Filter
    */
    @Bean("filter")
    public ShiroFilterFactoryBean getShiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String,String> filterMap  = new LinkedHashMap<>();
        //配置不会被拦截的链接
        filterMap.put("/static/**","anon");
        //配置退出，其中的退出代码shiro已经实现。
        filterMap.put("/logout","logout");
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        /**
        *前后端分离的项目不用写 登录页面和跳转页面
        */
        //设置登录页面,如果不设置，默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //shiroFilterFactoryBean.setLoginUrl("/login");
        //设置登录成功后跳转的页面
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面
        //shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        return shiroFilterFactoryBean;
    }





}
