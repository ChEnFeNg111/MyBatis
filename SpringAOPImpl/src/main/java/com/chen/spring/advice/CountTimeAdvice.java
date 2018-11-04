package com.chen.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CountTimeAdvice {

    @Around("within(com.chen.spring.service.OrderServiceTarget)")
    public void countTimeAdvice(ProceedingJoinPoint point){

        try {
            long start = System.nanoTime();

            //调用目标方法
            point.proceed();

            long end = System.nanoTime();

            System.out.println("方法调用总时间："+(end-start)+" (ns)");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }
}
