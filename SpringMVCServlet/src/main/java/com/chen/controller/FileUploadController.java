package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        System.out.println("上传的文件类型："+file.getContentType());
        System.out.println("上传的文件名："+file.getOriginalFilename());
        System.out.println("上传的文件大小："+file.getSize());
        System.out.println("上传的文件是否为空："+file.isEmpty());

        // 将上传的文件保存到本地
        file.transferTo(new File("G:\\"+file.getOriginalFilename()));

        return "hello";
    }
}
