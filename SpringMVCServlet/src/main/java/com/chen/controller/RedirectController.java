package com.chen.controller;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class RedirectController {

    /**
     *  方法一： 利用 HttpServletResponse 对象的重定向
     *    session 传值：
     *        优点： 安全性高，可传任意类型的数据
     *        缺点： 每个session都会占用服务器的内存
     *
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/r1")
    public String r1(HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("r1");
        // 一次会话之内有效
        session.setAttribute("name","chen");

        //response.sendRedirect("/r2");
        // 在视图名前面添加 `redirect:`，这时候springmvc就会把字符串当做重定向进行跳转，而不是再通过视图解析器进行解析
        return "redirect:/r2";
    }

    @RequestMapping("/r2")
    public String r2(HttpSession session){
        System.out.println("r2");
        System.out.println(session.getAttribute("name"));

        // 需要手动移除 session 的值
        session.removeAttribute("name");
        return "hello";
    }

    /**
     * 利用重定向地址后跟请求参数的方式
     *     优点： 不会占用服务器内存，可以向站外地址传参
     *     缺点： 安全性不高，数据大小有限制，不能传 复杂的 数据类型
     * @return
     */
    @RequestMapping("/r3")
    public String r3(){
        System.out.println("r3");
        return "redirect:/r4?username=zhangsan";
    }

    @RequestMapping("/r4")
    public String r4(String username){
        System.out.println("r4");
        System.out.println("username: "+username);
        return "hello";
    }

    /**
     *  SpringMVC提供的重定向方法：结合了上面两种方式的传参方式
     *    RedirectAttributes ： 传参，专门在重定向时传参
     *    @ModelAttributes:  接收值
     *       方式一（重定向后面跟请求参数的方式）： redirect.addAttribute("username","chen");
     *       方式二（使用session传值的方式）：redirect.addFlashAttribute("username","kobe");
     *
     * @param redirect
     * @return
     */

    @RequestMapping("/r5")
    public String r5(RedirectAttributes redirect){
        System.out.println("r5");
        // 采用的是 重定向后面跟请求参数的方式
        redirect.addAttribute("username","chen");

        // 采用的是 session 的传值方式
        redirect.addFlashAttribute("username","kobe");
        return "redirect:/r6";
    }

    @RequestMapping("/r6")
    public String r6(@ModelAttribute("username")String name){
        System.out.println("r6");
        System.out.println("username: "+name);
        return "hello";
    }
}
