package com.chen.controller;

import com.chen.entity.Barrage;
import com.chen.service.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class BarrageController {

    @Autowired
    private BarrageService service;

    @RequestMapping("barrage")
    @ResponseBody
    public List<Barrage> getBarrage(String text){

        if(text.length()>0){
            //将弹幕添加进数据库中
            service.insertBarrage(text);
        }
        
        // 再从数据库中查询出所有的弹幕
        List<Barrage> barrage = service.findBarrage();

        return barrage;
    }
}
