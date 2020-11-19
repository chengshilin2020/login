package com.example.docker3;

import com.example.docker3.entity.User;
import com.example.docker3.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Docker3ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
//            User a=  userMapper.selectByName("xiaomi");
//            System.out.println(a.getPassword());
        List<User> a=userMapper.selectByMyWrapper();
        a.stream().map(e ->e.getUsername()).forEach(System.out::println);
    }
}
