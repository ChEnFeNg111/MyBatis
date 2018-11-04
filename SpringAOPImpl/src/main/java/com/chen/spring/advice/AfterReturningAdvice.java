package com.chen.spring.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningAdvice {

    @AfterReturning("within(com.chen.spring.service.OrderServiceTarget)")
    public void afterReturningAdvice(){
        System.out.println("程序正常结束通知！！！！！");
    }
}
