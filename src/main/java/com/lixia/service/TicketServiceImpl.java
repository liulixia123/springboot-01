package com.lixia.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service //可以被扫描到，在项目一启动就自动注册到注册中心
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "你好，欢迎";
    }
}
