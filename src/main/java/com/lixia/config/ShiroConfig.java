package com.lixia.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //shirofilterfactorybean 这是第一步
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //添加内置过滤器
        /**
         * anon 无需认证就可以访问
         * authc 必须认真了才能访问
         * user 必须拥有记住我才能访问
         * perms 拥有对某个资源的权限才能访问
         * role 拥有这个角色权限才能访问
         */
        // 拦截
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/show/add","authc");
        filterMap.put("/show/update","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
        bean.setLoginUrl("/show/tologin");
        return bean;
    }
    //defaultwebsecuritymanager 这是第二步
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建 realm对象 需要自定义 这是第一步
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
