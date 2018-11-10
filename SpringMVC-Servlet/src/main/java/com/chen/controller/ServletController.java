package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ServletController {

    /**
     * 只要在控制器方法上加入request，response，session类型的参数，springmvc框架会把这些对象准备好作为方法参数传入
     *      建议不要直接在方法参数上使用 Servlet 的（request，response，session）对象
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/s1")
    public String s1(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("获取实际请求路径："+request.getRequestURI());
        System.out.println("获取客户端的ip："+request.getRequestURI());
        System.out.println("response的对象："+response);
        response.addCookie(new Cookie("user","chen"));
        System.out.println("session的对象："+session);

        return "hello";
    }

    /**
     *    @CookieValue("user"): 在请求红找到一个名为 user 的cookie的值
     *
     * @param username
     * @return
     */
    @RequestMapping("/s2")
    public String s2(@CookieValue("user")String username){
        System.out.println("获取到请求cookie的值："+username);
        return "hello";
    }
}
