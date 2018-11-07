package com.chen.controller;

import com.chen.entity.Page;
import com.chen.entity.Product;
import com.chen.service.ProductServie;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    // 利用注解 给属性赋值
    @Autowired
    private ProductServie productServie;

    @RequestMapping("/insert")
    public void insertControl(Product product,HttpServletResponse response) throws IOException {

        productServie.insertService(product);

        //重定向，controller层之间方法的互相调用
        response.sendRedirect("/select");
    }

    @RequestMapping("/select")
    public String products(String page,String size,Model model){

        // 便于分页管理的实体类
        Page p = new Page(page,size);

        // 查询到的结果集
        List<Product> list = productServie.selectList(p.getPage(),p.getSize());

        // 数据库中的总记录数
        int count = productServie.count();

        p.setCount(count);
        p.setList(list);

        model.addAttribute("p",p);
        return "list";

    }

    @RequestMapping("/delete")
    public void deleteControl(int id,HttpServletResponse response) throws IOException {
        productServie.delete(id);
        response.sendRedirect("/select");
    }

    @RequestMapping("update")
    public void updateControl(Product product, HttpServletResponse response) throws IOException {

        productServie.update(product);

        response.sendRedirect("/select");

    }

    @RequestMapping("selectById")
    public String  selectByIdControl(int id,Model model){
        Product product = productServie.selectById(id);

        // 添加进 request 作用域中
        model.addAttribute("s",product);

        return "update";
    }

    @RequestMapping("selectById1")
    public String  selectByIdControl1(int id,Model model){
        Product product = productServie.selectById(id);

        model.addAttribute("s",product);

        return "ProductOne";
    }


}
