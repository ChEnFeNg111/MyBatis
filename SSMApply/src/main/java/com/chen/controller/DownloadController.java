package com.chen.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
public class DownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           @RequestHeader("User-agent")String userAgent) throws IOException {
        //下载文件的路径
        String path = request.getServletContext().getRealPath("/images/");

        //构建file
        File file = new File(path+File.pathSeparator+filename);

        //ok表示 Http协议中的状态 200
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();

        //内容长度
        builder.contentLength(file.length());

        // application/octet-stream: 二进制流数据（最常见的文件下载）
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);

        //使用 URLDecoder.decode 对文件名进行解析
        filename = URLDecoder.decode(filename,"UTF-8");


        // 设置实际的响应文件名，告诉浏览器要以附件的形式打开（不同浏览器处理的方式不同）
        if(userAgent.indexOf("MSIE")>0){

            //如果是 IE 浏览器
            builder.header("Content-Disposition","attachment;filename"+filename);
        }else{
            //而 FireFox ,Chrome 等浏览器，需要说明编码的字符集
            // 注意： filename 后面有个 * 号，在UTF-8后面有两个单引号 ''
            builder.header("Content-Disposition","attachment;filename*=UTF-8''"+filename);
        }

        return builder.body(FileUtils.readFileToByteArray(file));
    }
}
