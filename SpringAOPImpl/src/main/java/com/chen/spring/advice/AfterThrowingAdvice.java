package com.chen.spring.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAdvice {

    @AfterThrowing(pointcut = "within(com.chen.spring.service.OrderServiceTarget)",throwing = "e")
    public void afterThrowingAdvice(Exception e){
        System.out.println("程序异常结束通知："+ e.getMessage());
    }
}
