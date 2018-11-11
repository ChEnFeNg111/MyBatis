package com.chen.mapper;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select name,password from users where name=#{name}")
    public User findByName(String name);
}
