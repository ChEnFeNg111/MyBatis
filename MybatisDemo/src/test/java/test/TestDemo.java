package test;

import com.chen.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {
    // 获取 SqlSession 的工厂类
    static SqlSessionFactory factory;

    // 获取 SqlSessionFactory 的 工具类
    static {

        try {
            // 获取配置文件的输入流
            FileInputStream is = new FileInputStream("src/main/resources/mybatis-config.xml");

           /* InputStream is = Resources.getResourceAsStream("mybatis-config.xml");*/

            // 获取 SqlSessionFactory 的对象
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 增
     */
    @Test
    public void insert(){
        // 通过 SqlSessionFactory 工厂类获取 SqlSession 的对象
        SqlSession sqlSession = factory.openSession();

        // 获取 sql 语句
        String sql = "com.chen.mapper.UserMapper.insert";

        // 要插入的对象 User
        User u = new User("james","6666");
        sqlSession.insert(sql,u);

        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }


    /**
     * 删：根据username删除
     */
    @Test
    public void delete(){
        // 通过 SqlSessionFactory 工厂类获取 SqlSession 的对象
        SqlSession sqlSession = factory.openSession();

        // 获取 sql 语句
        String sql = "com.chen.mapper.UserMapper.delete";

        // 执行

        sqlSession.delete(sql,"kobe");

        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }

    /**
     * 改：根据username，修改密码
     */
    @Test
    public void update(){
        // 通过 SqlSessionFactory 工厂类获取 SqlSession 的对象
        SqlSession sqlSession = factory.openSession();

        // 获取 sql 语句
        String sql = "com.chen.mapper.UserMapper.update";

        // 要插入的对象 User
        User u = new User("james","1000");

        // 执行语句
        sqlSession.update(sql,u);

        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }

    /**
     * 查：根据username查询单条语句
     */
    @Test
    public void selectOne(){
        // 通过 SqlSessionFactory 工厂类获取 SqlSession 的对象
        SqlSession sqlSession = factory.openSession();

        // 获取 sql 语句
        String sql = "com.chen.mapper.UserMapper.selectOne";



        // 执行语句
        User user = sqlSession.selectOne(sql, "james");

        System.out.println(user);
        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }

    /**
     * 查：查询所有
     */
    @Test
    public void selectAll(){
        // 通过 SqlSessionFactory 工厂类获取 SqlSession 的对象
        SqlSession sqlSession = factory.openSession();

        // 获取 sql 语句
        String sql = "com.chen.mapper.UserMapper.selectAll";



        // 执行语句
        List<User> list = sqlSession.selectList(sql);

        for (User user : list) {
            System.out.println(user);
        }
        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }
}
