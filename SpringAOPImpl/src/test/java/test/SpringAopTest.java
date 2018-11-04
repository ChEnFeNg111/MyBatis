package test;

import com.chen.spring.service.OrderService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 的AOP 动态代理调用流程：
 *    1) 获得 Spring 容器，检查 **是否** 要为哪些 <bean> 创建代理类
 *    2) 检查所有的切点表达式( @Around("within()") ),看哪些目标**匹配到了表达式**，为匹配到的目标动态**创建代理类**
 *    3) 获得对象时( getBean() )，检查该对象是否有已经创建好的代理类，如果已经有代理类，则返回该对象的代理类对象
 *    4) 代理类调用目标方法时，先经过 (多个)通知类，继续匹配切点表达式，如果匹配，则进行下面的通知调用（根据不同类型的通知进行先后调用）
 *    5) 匹配的通知调用后，再再通知内抵用目标方法
 */
public class SpringAopTest {
    @Test
    public void test1(){
        // 获得 spring 容器，
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // 返回的是 Spring 自动生成的动态代理类
        OrderService service = context.getBean(OrderService.class);

        service.service5();
    }
}
