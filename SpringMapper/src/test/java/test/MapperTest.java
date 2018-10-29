package test;

import com.chen.entity.Product;
import com.chen.mapper.ProductMapper;
import com.chen.service.ProductService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapperTest {
    //获得spring容器
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Test
    public void test1(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);
        Product p = new Product();
        p.setName("kobe");
        p.setPrice(6666.66);
        mapper.insert(p);
    }

    @Test
    public void test2(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);
        mapper.delete(100000000 );
    }

    @Test
    public void test3(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);
        Product product = new Product();
        product.setId(100000001);
        product.setName("chen");
        product.setPrice(8888.88);

        mapper.update(product);

    }

    @Test
    public void test4(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);
        Product product = mapper.findById(100000001);
        System.out.println(product);
    }

    @Test
    public void test5(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("start",0);
        map.put("size",10);

        List<Product> list = mapper.findByPage(map);
        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void test6(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);

        List<Product> list = mapper.PageLogical(new RowBounds(0,5));

        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void test7(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);

        List<Product> list = mapper.Page(0,15);

        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void test8(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductMapper mapper = context.getBean(ProductMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(100000003);
        list.add(100000004);
        list.add(100000005);
        mapper.deleteByIds(list);
    }

    //事务测试
    @Test
    public void test9(){
        // 利用反射，得到spring自动配置的 ProductMapper 的 <bean>
        ProductService service = context.getBean(ProductService.class);

        service.business1();
    }





}
