package com.lixia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/tologin")
    public String login(){
        return "login";
    }

    @RequestMapping("/user/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //业务
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/admin/index";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping(value = "/user/logout")
    public String logout(HttpSession session){
        session.setAttribute("loginUser",null);
        return "login";
    }
}
