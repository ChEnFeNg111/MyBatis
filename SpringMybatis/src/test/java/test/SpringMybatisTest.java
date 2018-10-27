package test;

import com.chen.entity.Product;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringMybatisTest {
    /*
    * 1. 创建spring容器
           根据xml文件应用程序Context容器(上下文)
           classpath指配置文件的位置, 起点有java, resources. 写路径时相对这个起点去写
    * */
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

    @Test
    public void test1(){
        /* 得到 SqlSession 对象*/
        SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start",0);
        map.put("size",5);

        List<Product> list = sqlSession.selectList("com.chen.mapper.ProductMapper.selectPage", map);

        for (Product product : list) {
            System.out.println(product);
        }
    }
}
