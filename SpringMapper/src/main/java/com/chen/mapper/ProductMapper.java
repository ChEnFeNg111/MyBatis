package com.chen.mapper;

import com.chen.entity.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    /**
     * 增
     */
    @Insert("insert into product(name,price) values(#{name},#{price})")
    void insert(Product product);

    /**
     * 删
     */
    @Delete("delete from product where id=#{id}")
    void delete(int id);

    /**
     * 改
     */
    @Update("update product set name=#{name},price=#{price} where id=#{id}")
    void update(Product product);

    /**
     * 查: 根据id查
     */
    @Select("select id,name,price from product where id=#{id}")
    Product findById(int id);

    /**
     * 分页查询(物理分页)
     */
    @Select("select id,name,price from product limit #{start},#{size}")
    List<Product> findByPage(Map map);

    /**
     * 分页查询（逻辑分页）
     */
    @Select("select id, name,price from product")
    List<Product> PageLogical(RowBounds rowBounds);

    /**
     *   *.java -> *.class 方法的参数名信息会丢失，所以再按m名称去找，则无法找到该参数名
     * @param m
     * @param n
     * @return
     */
    @Select("select id, name,price from product limit #{start},#{size}")
    List<Product> Page(@Param("start")int m,@Param("size")int n);

    /**
     * 动态sql，配合 XXXMapper.xml 映射文件进行 动态sql拼接
     *  注意： 1) 目录结构要一致
     *         2) xml中 namespace的取值与接口的包名类名要一致
     *         3) 接口中的方法名与xml中标签id对应
     *         4) 接口中的方法名不能重复（不支持重载）
     */
    void deleteByIds(List<Integer> ids);
}
