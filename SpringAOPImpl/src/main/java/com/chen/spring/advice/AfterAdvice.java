package com.chen.spring.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterAdvice {
    @After("within(com.chen.spring.service.OrderServiceTarget)")
    public void afterAdvice(){
        System.out.println("程序结束通知=====================");
    }
}
