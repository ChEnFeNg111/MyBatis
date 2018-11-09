package test;

import com.chen.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 的AOP 动态代理调用流程：
 *    1) 获得 Spring 容器，检查 **是否** 要为哪些 <bean> 创建代理类
 *    2) 检查所有的切点表达式( @Around("切点表达式") ),看哪些目标**匹配到了表达式**，为匹配到的目标动态**创建代理类**
 *    3) 获得对象时( getBean() )，检查该对象是否有已经创建好的代理类，如果已经有代理类，则返回该对象的代理类对象
 *    4) 代理类调用目标方法时，先经过 (多个)通知类，继续匹配切点表达式，如果匹配，则进行下面的通知调用（根据不同类型的通知进行先后调用）
 *    5) 匹配的通知调用后，再在通知调用目标方法
 */
public class CountTimeTest {

    @Test
    public void test1(){
        // 根据 spring-aop.xml 文件生成 spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");

        // 通过获取同一接口的 <bean>, 来获取 spring自动生成的代理类
        UserService service = context.getBean(UserService.class);

        System.out.println(service.getClass());
        // 调用目标方法
        service.insert();
        service.delete();
        service.update();
        service.select();


    }
}
