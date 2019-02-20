package com.jack.shiro.realm;

import com.jack.shiro.entity.SysPermission;
import com.jack.shiro.entity.SysRole;
import com.jack.shiro.entity.UserInfo;
import com.jack.shiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : peng
 * @Description : 自定义的Realm - 实体数据源
 * @Date : 2019-02-14 19:09
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo= (UserInfo) principal.getPrimaryPrincipal();
        for(SysRole role : userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission permission : role.getSysPermissionList()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从主体传过来的认证信息中，获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        //通过用户名查询数据库，获取凭证
        UserInfo user = userInfoService.findByUserName(userName);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo
                        (user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return authenticationInfo;
    }
}
