import com.chen.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

    @Test
    public void test1(){
        UserService userService = (UserService) context.getBean("userService");

        userService.update();
    }

}
