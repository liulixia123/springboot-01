package com.lixia.mapper;


import com.lixia.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper
@Mapper
@Repository
public interface UserMapper {
    public static final int age = 18;
    List<User> queryUserList();
    User queryUserById(int id);
    User queryUserByName(String name);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
