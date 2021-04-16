package com.lixia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","张三");
        model.addAttribute("msg1","<h1>非国家</h1>");
        model.addAttribute("user", Arrays.asList("掌声","dfjg"));
        return "index";
    }
}
