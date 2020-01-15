package com.xk.spring.boot.demo.dal.mapper;

import com.xk.spring.boot.demo.dal.entity.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pingchun@gegejia.com
 * @since 2020/1/14
 */
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "age",property = "age"),
            @Result(column = "name",property = "name")
    })
    List<UserEntity> queryAll();
}
