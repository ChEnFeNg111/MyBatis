package com.chen.service;

import com.chen.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class UserService {
    /* 旧方式：
       private UserDao userDao = new UserDao();
     */

    /**
     * 现在可以利用spring的 IOC（控制反转），将把对象的创建以及某些方法的调用交由 spring容器 来管理
     *   三种方法进行依赖注入：
     *      1)  set注入： properties配合 setXXX() 方法
     *      2) 构造注入： constructor-arg 配合构造函数
     *      3) 注解注入： @AutoWired | @Resource 配合  <context:annotation-config/>(启动注解，否则spring无法解析注解)
     *                   利用这个注解完成属性的赋值，把它加在需要注入的属性上, 或set方法上，或构造方法上
     *
     * */

    /**
     * 3) 注解注入 ： 利用反射，找到该变量的类型，自动赋值
     */
    /* @Autowired*/

     @Resource
     private UserDao userDao;

    /**
     * 1) set注入
     */
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    /**
      *  2) 构造注入
      */
    /*public UserService(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void insert(){
         System.out.println("userService1");
         userDao.insert();
     }

     public void update(){
         System.out.println("userService2");
         userDao.insert();
         userDao.update();
     }

}
