package com.lixia.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource() ;
    }
    //后台监控 相当于web.xml ServletRegistrationBean
    // spring内置了servlet容器，所有没有web.xml , ServletRegistrationBean用这种方法可以替带
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        HashMap<String,String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","admin");//登录的key是固定的，不能更改
        initParameters.put("loginPassword","123456");
        //允许谁能访问
        initParameters.put("allow","");//localhost只有本机能访问  zhangsan 具体名 为空表示都能访问
        //禁止谁访问
        //initParameters.put("kuangsheng","192.163.1.102");
        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }
}
