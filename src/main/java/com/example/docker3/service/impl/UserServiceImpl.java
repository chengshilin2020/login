package com.example.docker3.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.docker3.entity.User;
import com.example.docker3.mapper.UserMapper;
import com.example.docker3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Macky
 * @Title class BookServiceImpl
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByName(String username) {
        return baseMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getUsername,username));
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectByMyWrapper();
    }

    @Override
    public boolean save(User book) {
        return super.save(book);
    }

}
