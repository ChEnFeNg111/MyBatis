package com.chen.mapper;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select id,name from user where id=#{id}")
    public User findById(int id);
}
