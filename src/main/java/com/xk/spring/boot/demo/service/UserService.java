package com.xk.spring.boot.demo.service;

import com.xk.spring.boot.demo.dal.entity.UserEntity;
import com.xk.spring.boot.demo.dal.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pingchun@gegejia.com
 * @since 2020/1/14
 */
@Component
public class UserService {
    @Resource
    UserMapper userMapper;

    public List<UserEntity> queryAll(){
        List<UserEntity> userEntities =  userMapper.queryAll();
        return userEntities;
    }
}
