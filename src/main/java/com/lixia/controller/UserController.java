package com.lixia.controller;

import com.lixia.mapper.UserMapper;

import com.lixia.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/queryUserList")
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }
    @RequestMapping(value = "/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        return userMapper.queryUserById(id);
    }
    @RequestMapping(value = "/addUserList")
    public int addUser(){
        User user = new User();
        user.setUserName("lisi");
        user.setPassWord("123456");
        userMapper.addUser(user);
        return 1;
    }
    @RequestMapping(value = "/updateUsers/{id}")
    public int updateUser(@PathVariable("id") int id){
        User user = new User();
        user.setId(id);
        user.setUserName("lisi1");
        user.setPassWord("123456");
        userMapper.updateUser(user);
        return 1;
    }
    @RequestMapping(value = "/deleteUsers/{id}")
    public int deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return 1;
    }
}
