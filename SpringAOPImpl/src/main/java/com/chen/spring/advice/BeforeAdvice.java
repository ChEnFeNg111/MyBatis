package com.chen.spring.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdvice {

    @Before("within(com.chen.spring.service.OrderServiceTarget)")
    public void beforeAdvice(){
        System.out.println("前置通知===================");
    }
}
