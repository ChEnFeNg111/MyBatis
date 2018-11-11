package com.chen.controller;

import com.chen.utils.ProduceImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ImageController {

    @RequestMapping("/img")
    public void image(HttpServletResponse response,HttpSession session) throws IOException {

        System.out.println("aaaaa");

        // 设置图片格式
        response.setContentType("png");

        //得到验证码
        String code = ProduceImage.random();

        session.setAttribute("code",code);

        // 把图片作为响应 字节流 resp.getOutputStream()
        ProduceImage.getImage(code,response.getOutputStream());

    }
}
