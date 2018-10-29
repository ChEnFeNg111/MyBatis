package com.chen.service;

import com.chen.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ProductService {
    /**
     * 利用注解方式给变量进行赋值
     */
    @Autowired
    private ProductMapper productMapper;

    /**
     * 事务注解(@Transactional)：
     加在方法上，表示此方法受事务管理
     加在类上，那么这个类中的所有方法都受事务管理

     @Transactional注解详解
     默认情况下，只有方法出现的 是RuntimeException或Error以及它们的子类时（未检查异常），才会导致事务回滚

     如果要改变默认情况
     @Transactional(rollbackFor=异常类.class)
     那么方法如果出现了该异常，或该异常的子类异常时，就会回滚

     @Transactional(noRollbackFor=异常类.class)
     当遇到这种异常时，不会回滚事务


     最后要注意的是，在业务方法中不要自己try-catch捕获异常，否则spring无法自动回滚事务
     */
    @Transactional(rollbackFor = Exception.class)
    public void business1(){
        productMapper.delete(100000005);
        productMapper.delete(100000006);
        int i = 1/0;
        productMapper.delete(100000007);

    }
}
