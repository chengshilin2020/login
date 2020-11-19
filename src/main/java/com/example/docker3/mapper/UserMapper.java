package com.example.docker3.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.docker3.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Macky
 * @Title class BookMapper
 * @Descriptio n: TODO
 * @date 2019/7/12 20:46
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * effete
     *
     * @return
     */
    List<User> selectByMyWrapper();

    /**
     * wee
     *
     * @param name
     * @return
     */
    User selectByName(@Param("name") String name);
}
