package com.lixia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Map;
import java.util.List;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    //查询数据库的所有信息
    @GetMapping(value = "/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }
    @GetMapping(value = "/addUser")
    public String add(){
        String sql = "insert into user(username,password) values('张三','123456')";
        jdbcTemplate.update(sql);
        return "add_ok";
    }
    @GetMapping(value = "/updateUser/{id}")
    public String update(@PathVariable("id")Integer id){
        String sql = "update user set username= ? , password= ? where Id="+id;
        Object[] objects = new Object[2];
        objects[0] = "李四";
        objects[1] = "aaaaaa";
        jdbcTemplate.update(sql,objects);
        return "update_ok";
    }
    @GetMapping(value = "/deleteUser/{id}")
    public String delete(@PathVariable("id")Integer id){
        String sql = "delete from user where Id= ?";
        jdbcTemplate.update(sql,id);
        return "delete_ok";
    }
}
