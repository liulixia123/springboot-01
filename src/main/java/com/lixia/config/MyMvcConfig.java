package com.lixia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //视图控制跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("/tologin");
        registry.addViewController("/admin/index.html").setViewName("/admin/index");
        registry.addViewController("/admin/welcome.html").setViewName("/admin/welcome");
        registry.addViewController("/emps/list.html").setViewName("/emps");
        registry.addViewController("/emps/add.html").setViewName("/emps/toAdd");
        registry.addViewController("/emps/edit.html").setViewName("/emps/toUpdate");
    }

    // 自定义国际化组件
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    //添加登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/admin/**").excludePathPatterns(
                "/login.html","tologin",
                "/login", "/user/login","/user/logout", "/css/**", "/js/**", "/images/**", "/emps/add", "/emps/update", "/emps" +
                        "/del", "/emps/delAll","/userList","/addUser","/updateUser/","/deleteUser/");
    }
}
