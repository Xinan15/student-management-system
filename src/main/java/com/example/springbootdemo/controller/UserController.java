package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.service.UserServiceImpl;
import com.example.springbootdemo.utils.Result;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)

    public String addUser (@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        userService.addUser(username, password);
        return Result.okGeString();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)

    public String delUser (@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        userService.addUser(username, password);
        return Result.okGeString("delete success");
    }
    
}
