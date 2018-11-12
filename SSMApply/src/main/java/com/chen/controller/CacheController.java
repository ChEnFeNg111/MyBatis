package com.chen.controller;

import com.chen.entity.User;
import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CacheController {

    @Autowired
    private UserService service;

    @RequestMapping("/cache1")
    @ResponseBody // 返回 JSON 数据
    @Cacheable(cacheNames = "user") // 将找到的  user  放入“user”缓存中
    /**
     * 缓存流程：
     *     检查缓存内容：
     *           若缓存中没有这条记录，则执行该方法，将从数据库中查找出的 **返回结果** 存入缓存中
     *           若缓存中有这条记录，则直接将缓存中的数据返回，不需要去数据库中查找（不执行该方法），从而提高效率
     */
    public User findById(int id){
        System.out.println("aaaaa");
        return service.findById(id);
    }

    @RequestMapping("/cache2")
    @ResponseBody
    @CacheEvict(cacheNames = "user",allEntries = true) // 清除 “user” 区域中所有的缓存,使之前的缓存失效
    public String update(){
        System.out.println("update");
        return "update";
    }

    @RequestMapping("/cache3")
    @ResponseBody
    @CachePut(cacheNames = "user") // 总是执行该方法，并每次执行该方法后，将返回结果更新进 “user”缓存中
    public User update(int id){
        System.out.println("ccccc");
        return service.findById(id);
    }

}
