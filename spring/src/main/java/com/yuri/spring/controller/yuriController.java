package com.yuri.spring.controller;

import org.springframework.web.bind.annotation.*;
import com.yuri.spring.entity.User;

// RestController 只返回数据 Controller 返回数据加界面
@RestController
@CrossOrigin
public class yuriController {
    // 只接受浏览器的get请求
    @GetMapping("/hello")
    // 浏览器地址栏传递的参数类型 ?string="内容"需要对应
    public String hello() {
        return "yuri is yes";
    }

    // 如果请求名字和方法名字对不上就需要这样，可以设置是否必须
    @GetMapping("hello_2")
    public String hello_2(@RequestParam(value = "yuri", required = false) String string) {
        return string;
    }

//    // post请求
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(User user) {
//        return user.toString();
//    }

    // json数据需要名字一一对应，且需要添加requestBody
    @RequestMapping(value = "/login_json", method = RequestMethod.POST)
    public String login_json(@RequestBody User user) {
        return user.toString();
    }

}
