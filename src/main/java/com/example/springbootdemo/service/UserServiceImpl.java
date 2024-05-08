package com.example.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.pojo.UserPojo;

@Service
public class UserServiceImpl {

    @Autowired
    UserDao userDao;

    public void addUser() {
        userDao.insert(new UserPojo());
    }
}