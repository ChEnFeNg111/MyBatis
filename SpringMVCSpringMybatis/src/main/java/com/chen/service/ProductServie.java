package com.chen.service;

import com.chen.entity.Product;
import com.chen.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServie {

    //利用注解方式给属性赋值。底层利用了反射机制
    @Autowired
    private ProductMapper mapper;

    public void insertService(Product product){
        mapper.insert(product);
    }

    public void update(Product product){
        mapper.update(product);
    }

    public void delete(int id){
        mapper.delete(id);
    }

    public List<Product> selectList(int page,int size){
        List<Product> list = mapper.selectAll(page,size);
        return list;
    }

    public Product selectById(int id){
        Product product = mapper.selectById(id);
        return product;
    }

    public int count(){
        int count = mapper.selectCount();
        return count;
    }
}
