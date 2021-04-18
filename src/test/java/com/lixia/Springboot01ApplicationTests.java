package com.lixia;

import com.lixia.pojo.Person;
import com.lixia.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot01ApplicationTests {
    @Autowired
    private Person person;
    @Autowired
    DataSource dataSource;
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() throws SQLException {
        //查看默认数据源
        System.out.println(dataSource.getClass());
        //获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //连接关闭
        connection.close();
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("你好呀");
        mailMessage.setText("欢迎你");
        mailMessage.setTo("1518545702@qq.com");
        mailMessage.setFrom("1518545702@qq.com");
        mailSender.send(mailMessage);

    }

}
