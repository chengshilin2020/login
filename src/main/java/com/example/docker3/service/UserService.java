package com.example.docker3.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.docker3.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Macky
 * @Title interface BookService
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public interface UserService extends IService<User> {

    /**
     * 保存书籍信息
     *
     * @param user
     * @return
     */
    @Override
    boolean save(User user);

    /**
     * 查询用户是否存在
     *
     * @return
     */
    List<User> getUserByName(String username);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<User> getUserList();
}
