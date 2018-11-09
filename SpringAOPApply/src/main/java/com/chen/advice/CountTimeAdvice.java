package com.chen.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


//告知spring容器该类是个切面类
@Aspect
public class CountTimeAdvice {

    // 只要方法上使用了 @Transactional 注解，就匹配该通知方法

    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void CountTime(ProceedingJoinPoint point){

        try {
            long start = System.nanoTime();

            //调用目标方法（底层通过反射机制）
            point.proceed();

            long end = System.nanoTime();

            System.out.println("方法的调用时间："+(end-start));

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
