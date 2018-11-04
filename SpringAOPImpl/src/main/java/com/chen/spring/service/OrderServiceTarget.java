package com.chen.spring.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 目标类：专门处理业务逻辑，不参与别的逻辑处理，别的重复逻辑代码通过 Spring的自动生成的代理类（proxy） 来让 通知类（advice）帮忙实现
 */
public class OrderServiceTarget implements OrderService {
    @Override
    @Transactional
    public void service1() {
        System.out.println("insert");
        System.out.println("delete");
    }

    @Override
    public void service2() {
        System.out.println("update");
        System.out.println("delete");
        int i =1/0;
    }

    @Override
    public void service3() {
        System.out.println("insert");
        System.out.println("select");
    }

    @Override
    public void service4() {
        System.out.println("insert");
        System.out.println("update");
    }

    @Override
    public void service5() {
        System.out.println("select");
        System.out.println("delete");
    }
}
