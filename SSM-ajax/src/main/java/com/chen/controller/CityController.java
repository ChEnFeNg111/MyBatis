package com.chen.controller;

import com.chen.entity.City;
import com.chen.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityService service;

    @RequestMapping("/city")
    @ResponseBody
    public List<City> findById(int id){
        return service.findById(id);
    }
}
