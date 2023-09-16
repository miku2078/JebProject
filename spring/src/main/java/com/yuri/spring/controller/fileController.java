package com.yuri.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
public class fileController {
    @PostMapping(value = "/up")
    public String upFile(String name, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("name -> " + name);
        System.out.println("type -> " + file.getContentType());
        System.out.println("fileName -> " + file.getOriginalFilename());
        if(saveFile(request.getServletContext().getRealPath("/upload/"), file)) {
           return "上传成功!";
        }
        return "上传失败!";
    }

    public boolean saveFile(String path, MultipartFile file) throws IOException {
        File new_file = new File(path);
        if(!new_file.exists()) {
            if(!new_file.mkdir()) {
                System.out.println("创建目录失败!");
                return false;
            }
        }
        System.out.println("path -> " + path);
        file.transferTo(new File(path + file.getOriginalFilename()));
        return true;
    }
}
