package com.lixia.config;

import com.lixia.pojo.User;
import com.lixia.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //用户名 密码数据
        /*String username="admin";
        String password="123456";
        if(!userToken.getUsername().equals(username)){
            return null;//抛出异常
        }*/
        //连接数据库来测试用户登录
        User user = userService.queryUserByName(userToken.getUsername());
        if(user == null){
            return null;
        }
        String password = user.getPassWord();
        //密码认证 shiro帮我们做
        return new SimpleAuthenticationInfo("",password,"");
    }
}
