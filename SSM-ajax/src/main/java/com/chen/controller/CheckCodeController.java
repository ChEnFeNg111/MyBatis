package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckCodeController {

    @RequestMapping("/checkcode")
    @ResponseBody
    public Map<String,Object> checkCode(String code, HttpSession session){


        String str = (String) session.getAttribute("code");

        System.out.println(code+"-----"+str);

        Map<String,Object> map = new HashMap<>();
        if(str.equals(code)){
            map.put("check",true);
        }else{
            map.put("check",false);
        }

        return map;
    }
}
