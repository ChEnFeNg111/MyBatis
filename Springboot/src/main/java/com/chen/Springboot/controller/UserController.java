package com.chen.Springboot.controller;

import com.chen.Springboot.domain.User;
import com.chen.Springboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("find")
    @ResponseBody
    public User findById(@Param("id") int id){
        System.out.println(id);
        return service.findById(id);
    }








    @RequestMapping("hello")
    @ResponseBody
    public String demo(Model model){

        model.addAttribute("text","hello");
        return "hello";
    }
}
