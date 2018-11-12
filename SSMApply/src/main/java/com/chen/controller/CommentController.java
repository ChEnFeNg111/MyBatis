package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {

    @RequestMapping("/comment")
    @ResponseBody
    public Map<String,Object> c1(String content) throws InterruptedException {
         System.out.println(content);
         Map<String,Object> map = new HashMap<>();
         Thread.sleep(2000);
         map.put("content",content);
         return map;
    }
}
