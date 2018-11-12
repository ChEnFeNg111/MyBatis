package com.chen.service;

import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public User findById(int id){
        return mapper.findById(id);
    }
}
