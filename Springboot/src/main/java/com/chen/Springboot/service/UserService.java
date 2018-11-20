package com.chen.Springboot.service;

import com.chen.Springboot.domain.User;
import com.chen.Springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // mapper 报错是 idea 检测，实际运行没有错误
    @Autowired
    private UserMapper mapper;

    public User findById(int id){
        return mapper.findById(id);
    }
}
