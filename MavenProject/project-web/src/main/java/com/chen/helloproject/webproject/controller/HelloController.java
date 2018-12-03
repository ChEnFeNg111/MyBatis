package com.chen.helloproject.webproject.controller;

import com.chen.helloproject.domainproject.domain.Industry;
import com.chen.helloproject.serviceproject.service.IndustryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    private IndustryService service;

    @RequestMapping("/industry")
    public ModelAndView industry(@Param("id") int id){
        Industry industry = service.findById(id);

        System.out.println(industry);

        ModelAndView mv = new ModelAndView();

        mv.setViewName("hello");
        mv.addObject("industryid",industry.getIndustryid());
        mv.addObject("industryname",industry.getIndustryname());
        mv.addObject("parentid",industry.getParentid());
        return mv;
    }

    @RequestMapping("/hello")
    public String demo(){
        System.out.println("hello");
        return "hello";
    }
}
