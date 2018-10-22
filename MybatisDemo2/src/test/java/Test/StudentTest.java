package Test;

import com.chen.entity.Product;
import com.chen.entity.Student;
import com.chen.entity.Teacher;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    // 获取 SqlSession 的工厂类
    static SqlSessionFactory factory;

    static {
        try {
            // 获取配置文件的输入流
            FileInputStream is = new FileInputStream("src/main/resources/mybatis-config.xml");
            // 获得工厂类
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    * 获取自动增长列的值
    * */
    @Test
    public void insert(){
        // 获得 sqlSession
        SqlSession sqlSession = factory.openSession();
        // 获取唯一标识
        String path = "com.chen.mapper.insert";
        // 要传入的参数
        Student s = new Student();
        s.setName("kobe");
        s.setAge(18);

        System.out.println(s);

        // 执行sql语句
        sqlSession.insert(path,s);
        // 手动提交事务
        sqlSession.commit();

        System.out.println(s);
        // 关闭sqlSession
        sqlSession.close();
    }


    /*
    * 动态sql ： 拼接sql forEach标签
    * */
    @Test
    public void delete(){
        SqlSession sqlSession = factory.openSession();

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);

        sqlSession.delete("com.chen.mapper.delete",list);

        sqlSession.commit();
        sqlSession.close();
    }

    /*
    * 动态sql 拼接： if标签 set标签
    * */
    @Test
    public void update(){
        SqlSession sqlSession = factory.openSession();

        Student s = new Student();
        s.setName("curry");
        s.setAge(30);
        s.setId(3);

        sqlSession.update("com.chen.mapper.update",s);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 动态sql if标签 where标签   多条件查询：模糊查询 & 范围查询
     */
    @Test
    public void selectByCondition(){
        SqlSession sqlSession = factory.openSession();
        Map<String,String> map = new HashMap<String, String>();

        map.put("name","%e%");
        map.put("minAge","10");
        map.put("maxAge","40");

        List<Student> list = sqlSession.selectList("com.chen.mapper.selectByCondition", map);

        sqlSession.commit();

        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    /*
    * 分页查询
    * */

    /*物理分页*/
    @Test
    public  void selectPage(){
        SqlSession sqlSession = factory.openSession();
        Map<String,String> map = new HashMap<String, String>();

        map.put("start","6");
        map.put("size","3");

        List<Student> list = sqlSession.selectList("com.chen.mapper.selectPage", map);

        sqlSession.commit();

        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    /*逻辑分页*/
    @Test
    public void selectByLogical(){
        SqlSession sqlSession = factory.openSession();
        /*
        * 底层通过 JDBC 的代码实现分页
        * RowBounds(offset,limit): offset：起始位置， limit：要查询的数量
        * */
        List<Student> list = sqlSession.selectList("com.chen.mapper.selectLogical",null,new RowBounds(0,3));

        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    /*
    * 解决表与实体类不匹配是的情况，类名不同
    * */

    /*方法一： 取列别名*/
    @Test
    public void otherName(){
        SqlSession sqlSession = factory.openSession();
        Teacher o = sqlSession.selectOne("com.chen.mapper.selectName", 5);

        System.out.println(o);

        sqlSession.commit();
        sqlSession.close();
    }

    /*方法二： 使用 resultMap 代替 resultType 完成映射 */

    @Test
    public void selectMap(){
        SqlSession sqlSession = factory.openSession();
        Teacher t = sqlSession.selectOne("com.chen.mapper.selectMap",2);
        System.out.println(t);

        sqlSession.commit();
        sqlSession.close();
    }

    /*
    * 连接查询
    * */
    @Test
    public void innerJoin(){
        SqlSession sqlSession = factory.openSession();

        Product p = sqlSession.selectOne("com.chen.mapper.innerJoin", 1);

        System.out.println(p);

        sqlSession.commit();
        sqlSession.close();
    }





}

