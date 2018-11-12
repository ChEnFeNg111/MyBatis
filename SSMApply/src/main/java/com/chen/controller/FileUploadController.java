package com.chen.controller;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

     // 上传文件 会自动绑定到 MultipartFile 对象中
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String descirption,
                         MultipartFile file,
                         Model model) throws IOException {
        System.out.println("文件的描述信息： "+descirption);

        if(!file.isEmpty()){
            // 得到上传文件的路径
            String path = request.getServletContext().getRealPath("/images/");

            String filename = file.getOriginalFilename();

            // 将文件名添加进行 model 对象中（request作用域）
            model.addAttribute("filename",filename);

            File filepath = new File(path,filename);

            //判断该路径是否存在，如果不存在则创建一个新的路径
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }

            //将上传的文件保存到一个目标文件中
            file.transferTo(new File(path+File.pathSeparator+filename));

            System.out.println("上传的文件路径："+path+filename);

            return "download";
        }else{
            return "error";
        }
    }
}
