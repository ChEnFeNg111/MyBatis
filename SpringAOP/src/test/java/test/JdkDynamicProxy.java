package test;

import com.chen.service.TranscationAdvice;
import com.chen.service.UserService;

import java.lang.reflect.Proxy;

/**
 *  JDK 的动态代理：自动生成代理类，不用程序员自己实现代理类，直接生成了*.class字节码, 加载该class到虚拟机
 */
public class JdkDynamicProxy {

    public static void main(String[] args) {
        /**
         * 创建一个新的代理类对象
         *         参数1， 类加载器
         *         参数2， 代理类, 要实现哪些接口 Class[]{}
         *         参数3， InvocationHandler (通知对象), 其中包含了代理要执行的代码
         */
        // 得到类加载器
        ClassLoader classLoader = JdkDynamicProxy.class.getClassLoader();

        // 返回的是一个 代理类对象：JDK自动生成的代理类
        UserService service = (UserService) Proxy.newProxyInstance(classLoader,new Class[]{UserService.class},new TranscationAdvice());

        service.business1();
    }
}
