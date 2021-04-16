package com.lixia.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiroController {

    @RequestMapping(value = "/show/index")
    public String index(Model model){
        model.addAttribute("msg","hello world!");
        return "test/index";
    }
    @RequestMapping(value = "/show/add")
    public String add(Model model){
        model.addAttribute("msg","添加");
        return "test/add";
    }
    @RequestMapping(value = "/show/update")
    public String update(Model model){
        model.addAttribute("msg","修改");
        return "test/update";
    }
    @RequestMapping(value = "/show/tologin")
    public String tologin(){
        return "test/login";
    }
    @RequestMapping(value = "/show/login")
    public String login(String username,String password,Model model){
        //获取当前用户对象
        Subject currentUser = SecurityUtils.getSubject();

        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);//执行了登录操作
            return "test/index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名不正确");
            return "test/login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码不正确");
            return "test/login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg","账号被锁定");
            return "test/login";
        }

    }

}
