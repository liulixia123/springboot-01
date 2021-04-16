package com.lixia.config;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求参数中语言参数
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就使用默认
        //如果请求携带了国际化参数
        if(!StringUtils.isEmpty(language)){
            //得到国家和地区
            String[] split = language.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
