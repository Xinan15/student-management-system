// controller层，其主要作用是接收前端请求，向后调用 service层 的方法，再返回结果给前端
// controller层是直接与前端交互的层，使用 RequestMapping 注解，用于接收前端请求
package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.service.UserServiceImpl;
import com.example.springbootdemo.utils.Result;

@RestController
// @RestController 的Rest 是一个 RestAPI 的缩写，意思是这个类是用来处理 RestAPI 请求的
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    // 意思是 当前端请求的路径是 /addUser 时，调用 addUser 方法

    public String addUser (@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        userService.addUser(username, password);
        return Result.okGeString();
    }

    // @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)

    // public String delUser (@RequestParam("username") String username,
    //                        @RequestParam("password") String password) {
    //     userService.addUser(username, password);
    //     return Result.okGeString("delete success");
    // }
    
}
