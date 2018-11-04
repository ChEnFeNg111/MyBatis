package com.chen.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 通知类： 事务管理的方法
 *
 */

//切面= 通知+切点
@Aspect
public class TranscationAdvice {
    /**
     *  @Around:环绕通知：  决定了哪些目标方法会与 该通知方法一起使用, 通过切点表达式 within(包名.类名) 匹配**哪些目标方法**要和下面的**通知方法**结合到一起使用
     *
     *         作用: 当 OrderServiceTarget中的任意一个方法调用时,都会和该 transcation() 方法结合在一起
     */
   @Around("within(com.chen.spring.service.OrderServiceTarget)")

    /**
     * execution(访问修饰符 返回值类型 包名.类名.方法名( 参数类型... )): 指定目标方法配合该公职方法一起使用
     * 注意 ' * ' :可以匹配任意类型, 可以出现在方法返回值，方法名，类名当中
     * 注意' .. ' :可以匹配方法参数，表示参数的个数和类型都是任意的
     */
   /* @Around("execution(public * com.chen.spring.service.OrderServiceTarget.service3(..))")*/

    /**
     * @annotation(包名.注解名)
     * 它是根据方法上的注解进行匹配, 如果有注解则匹配, 只匹配使用了 @Transcational 注解的目标方法
     *
     * */
    //@Around("@annotation(org.springframework.transaction.annotation.Transactional)")

    // 这个方法统称为 通知方法，负责处理重复的逻辑代码，并在内部调用相对应的目标方法
    public Object transcation(ProceedingJoinPoint point){
        System.out.println("开启事务");
        Object obj = null;
        try{
            // 调用目标方法
            obj = point.proceed();

            System.out.println("提交事务");
        } catch (Throwable throwable) {
            System.out.println("回滚事务");
            throwable.printStackTrace();
        }

        return  obj;
    }
}
