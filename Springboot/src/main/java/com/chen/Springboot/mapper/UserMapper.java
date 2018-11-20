package com.chen.Springboot.mapper;

import com.chen.Springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id,name from user where id=#{id}")
    public User findById(int id);
}
