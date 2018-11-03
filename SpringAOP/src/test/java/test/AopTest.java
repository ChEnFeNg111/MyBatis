package test;

import com.chen.service.UserService;
import com.chen.service.UserServiceProxy;
import com.chen.service.UserServiceTarget;

/**
 *  静态代理： 自己实现代理类  *.java -> javac -> *.class -> java -> 加载该class到虚拟机
 */
public class AopTest {

    public static void main(String[] args) {
        /**
         * 获得的是代理类对象：class com.chen.service.UserServiceProxy
         **/
        // 通过 代理类 将 通知类 和 目标类 结合在一起调用
        UserService service = new UserServiceProxy();
        service.business1();

        System.out.println("================================");

        // 直接调用目标类，获得的是 目标类对象：class com.chen.service.UserServiceTarget
        UserService service1 = new UserServiceTarget();
        service1.business1();

    }
}
