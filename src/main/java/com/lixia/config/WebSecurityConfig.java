package com.lixia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页可以所有人访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("vip1")
                .antMatchers("user/**").hasRole("vip2");
        //没有权限会开启登录页
        http.formLogin();
        //防止网站攻击,默认是开启的，现在关闭
        http.csrf().disable();
        //开启注销
        http.logout().logoutSuccessUrl("/login");

        //记住我
        http.rememberMe().rememberMeParameter("remember");
    }
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //数据从内存中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("lixia18").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2");
    }
}
