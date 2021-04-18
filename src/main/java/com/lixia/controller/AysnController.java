package com.lixia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lixia.service.AsynService;

@RestController
public class AysnController {
    @Autowired
    AsynService aysnService;

    @RequestMapping(value = "aysn/hello")
    @ResponseBody
    public String hello() {
        aysnService.hello();//停顿3秒后访问
        return "ok";

    }
}
