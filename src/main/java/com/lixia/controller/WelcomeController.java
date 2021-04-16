package com.lixia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WelcomeController {
    @RequestMapping(value ="/admin/welcome")
    public String index(){
        return "admin/welcome";
    }
}
