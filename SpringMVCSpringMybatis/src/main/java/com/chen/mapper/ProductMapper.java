package com.chen.mapper;

import com.chen.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用接口管理 sql 语句
 * */
public interface ProductMapper {

    @Insert("insert into product (id,name,price) values(#{id},#{name},#{price})")
    void insert(Product product);

    @Select("select id,name,price from product limit #{start},#{size}")
    List<Product> selectAll(@Param("start")int s, @Param("size")int z);

    @Update("update product set name=#{name},price=#{price} where id=#{id}")
    void update(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(int id);

    @Select("select id,name,price from product where id=#{id}")
    Product selectById(int id);

    @Select("select count(*) count from product")
    int selectCount();

}
