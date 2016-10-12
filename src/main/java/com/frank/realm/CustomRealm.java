package com.frank.realm;

import com.frank.entity.User;
import com.frank.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 自定义Shiro拦截器
 *
 * @author barry215
 * @create 2016-10-12 16:15
 */

public class CustomRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String email = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        User user = userService.getUserByEmail(email);
        if (user == null){
            throw new UnknownAccountException();
        }else if(user.getActivate().equals("N")){
            throw new LockedAccountException();
        }else if(!user.getPassword().equals(password)){
            throw new AuthenticationException();
        }else {
            //new SimpleAuthenticationInfo(可以是userName或是对象,password,this.getName());
            //在这里第一个参数传入对象的时候，在后面可以使用(User)SecurityUtils.getSubject().getPrincipal()获得对象
            return new SimpleAuthenticationInfo(user,password,this.getName());
        }
    }
}
