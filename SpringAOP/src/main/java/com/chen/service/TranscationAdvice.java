package com.chen.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *  通知类： 放置重复的逻辑代码，例如 事务管理,   实现 InvocationHandler 通知接口（包含invoke()方法）,使得代码更加通用
 *
 *      1) 反射调用了目标对象的方法
 * 		2) 把重复代码和目标方法联系在了一起
 */
public class TranscationAdvice implements InvocationHandler {

    private UserServiceTarget target = new UserServiceTarget();

    /**
     *  通知类中重复代码的方法，通过方法的反射调用
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        System.out.println("开启事务");
        Object obj = null;
        try {
            // 调用目标方法
            obj = method.invoke(target,args);

            System.out.println("提交事务");
        }catch (Exception e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }

        return obj;
    }
}
