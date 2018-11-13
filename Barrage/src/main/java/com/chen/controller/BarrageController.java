package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class BarrageController {

    @RequestMapping("barrage")
    @ResponseBody
    public Map<String,Object> getBarrage(String text){

        Map<String,Object> map = new HashMap<>();
        map.put("text",text);


        return map;
    }
}
