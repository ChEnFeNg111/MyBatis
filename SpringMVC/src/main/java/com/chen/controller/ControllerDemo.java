package com.chen.controller;

import com.chen.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 *  请求被处理的调用流程：
 *       1) 请求从浏览器发送到tomcat: http://localhost:8080/test1
 *       2) tomcat先去精确匹配该访问路径的servlet，如果匹配到了,则进入该servlet进行业务处理
 *       3) 若没有匹配到，则匹配到了**前控制器**（DispatcherServlet）的路径 “ / ”,由它来处理请求
 *       4) DispatcherServlet 则去spring容器中查找控制器中每个带有@RequestMapper("/路径")的方法
 *       5) 如果匹配成功，则执行该方法，并返回一个结果（视图名）到 视图解析器中，解析器解析出该请求应该跳转到哪个jsp页面，并返回响应到浏览器上显示
 *       6) 否则报 404 错误！！！
 */

//指示该类是个 Controller 控制器类
@Controller
public class ControllerDemo {

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("进入了ControllerDemo控制器");
        //返回的是 视图名（jsp的名字）
        return "hello";
    }

    /**
     * 获取请求参数的三种方法： 相当于servlet中的 request.getParameter("参数名")
     *     1) 通过 方法参数 与 请求参数 一一对应 （表单get方式的提交）,spring容器会自动将数据类型转化
     *           注意： 日期格式 @DateTimeFormat(pattern="yyyy-MM-dd")将日期按规定格式输出，否则报 400 bad request
     *           eg: http://localhost:8080/test2?name=chen&age=18&birthday=1997-11-24
     *
     *     2) 将 请求参数封装到一个**实体类**中，方法参数就是这个实体类
     *           eg: http://localhost:8080/test3?name=chen&age=18&birthday=1997-11-24
     *
     *     3) 路径参数： 将请求参数写到访问路径中，通过 **RequestMapper(" /路径/{参数名} ")** 获取到该请求参数的值
     *                   再在方法参数中利用注解**@PathVariable("参数名")**将获取到的**请求参数值**赋值给方法中的**参数**
     *           eg: @RequestMapping("/test4/{id}/{name}")
     *               @PathVariable("id")int x,@PathVariable("name")String n
     *               http://localhost:8080/test4/1/chen
     *
     */
    @RequestMapping("/test2")
    public String test2(String name, int age, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        System.out.println("name: "+name+" age: "+age+" birthday:"+birthday);
        // 返回视图名,进入视图解析器
        return "hello";
    }

    @RequestMapping("/test3")
    public String test3(User user){
        System.out.println("name: "+user.getName()+" age: "+user.getAge()+" birthday:"+user.getBirthday());
        return "hello";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable("id")int x,@PathVariable("name")String n){
        System.out.println("name: "+n+" id: "+x);
        return "hello";
    }

    /**
     * Model: 代表了模型数据, 它也是加在控制器方法之上 可以直接使用它的实现类ModelMap或Map
     *         向模型添加数据: model.addAttribute("变量名", 值);
     *         model中的数据在转发之前，都会被存入request作用域
     *         相当于 request.setAttribute("username","zhangsan");,添加进 request 的作用域,在 jsp 页面上用 EL(${}) 表达式取出来
     */

    @RequestMapping("/test5")
    public String test5(User user, Model model){
        model.addAttribute("name",user.getName());
        model.addAttribute("age",user.getAge());
        model.addAttribute("birthday",user.getBirthday());

        return "hello";
    }

    @RequestMapping("/test6")
    @ResponseBody//把方法的返回值转换成json字符串
    public User test6(){
        User user = new User("chen",18,new Date());
        return user;
    }

}
