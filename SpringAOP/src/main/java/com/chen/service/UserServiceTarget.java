package com.chen.service;

/**
 * UserService 的目标类，实现 UserService 接口
 *    单一职责原则：专门处理业务逻辑，不处理别的逻辑，例如事务管理等
 */
public class UserServiceTarget implements UserService{

    @Override
    public void business1() {
        System.out.println("insert");
        System.out.println("update");
        System.out.println("delete");
    }

    @Override
    public void business2() {
        System.out.println("select");
        System.out.println("update");
    }
}
