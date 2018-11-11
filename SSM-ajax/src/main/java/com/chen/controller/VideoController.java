package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class VideoController {

    @RequestMapping("/pinglun")
    @ResponseBody
    public Map<String,Object> p1(String content) throws InterruptedException {
        System.out.println(content);
        Thread.sleep(2000);
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
}
