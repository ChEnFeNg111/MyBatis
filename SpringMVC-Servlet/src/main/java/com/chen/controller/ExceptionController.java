package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    /**
     * 自己手动捕获异常
     * @return
     */
    @RequestMapping("/e1")
    public String e1(){

        try{
            System.out.println("e1");
            int i =1/0;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            return "error";
        }

        return "hello";
    }

    /**
     *  springmvc 帮我们自动捕获异常
     *      @ExceptionHandler(ArithmeticException.class)： 只能精确匹配异常类型，匹配到了，则执行该方法，若不匹配，则继续报错
     *      @ExceptionHandler(Exception.class)： 若没匹配到该精确类型，则执行该异常的方法
     *
     *   ***注意***: 以上自动捕获异常值捕获 ***本Controller*** 发生的异常，别的 Controller 若发生异常，则无法捕获
     * @return
     */
    @RequestMapping("/e2")
    public String e2(){
        System.out.println("e2");
        int i = 1/0;
        int[] arr = new int[5];
        System.out.println(arr[6]);
        return "hello";
    }

    @ExceptionHandler(ArithmeticException.class)
    public String exception1(ArithmeticException e){
        System.out.println("错误信息："+e.getMessage());

        return "error";
    }

   @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String exception2(ArithmeticException e){
        System.out.println("错误信息："+e.getMessage());

        return "error";
    }


}
