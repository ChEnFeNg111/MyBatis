package com.chen.controller;

import com.chen.entity.User;
import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private UserService service;

    @RequestMapping("/register")
    @ResponseBody
    public Map<String,Object> findByName(String name){
        System.out.println(name);
        User user = service.fingByName(name);
        Map<String,Object> map = new HashMap<>();

        if(user != null){
            map.put("exits",true);
        }else {
            map.put("exits",false);
        }

        return map;
    }
}
