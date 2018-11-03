package com.chen.service;

import java.lang.reflect.Method;

/**
 *  UserService 的静态代理类，必须与目标类实现同一 UserService 接口,（目的是让使用者察觉不出是代理替换了原来的目标）
 *   1) 调用通知类的invoke方法
 * 	 2) 获取方法对象和方法实际参数
 */
public class UserServiceProxy implements UserService {

    private TranscationAdvice advice = new TranscationAdvice();

    static Method business1;
    static Method business2;

    static {
        // 通过反射获得 UserService 类对象
        Class<UserService> c = UserService.class;
        try {
            // 通过反射调用获得方法对象，
            business1 = c.getMethod("business1");
            business2 = c.getMethod("business2");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void business1() {
        //调用通知类的 invoke() 方法
        advice.invoke(this,business1,new Object[]{});
    }

    @Override
    public void business2() {
        //调用通知类的 invoke() 方法
        advice.invoke(this,business2,new Object[]{});
    }
}
