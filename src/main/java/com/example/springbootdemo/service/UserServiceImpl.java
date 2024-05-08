package com.example.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.pojo.UserPojo;

@Service
public class UserServiceImpl {

    @Autowired
    UserDao userDao;

    public void addUser(String username, String password) {
        userDao.insert(new UserPojo(username, password));
    }

    public void deleteUser(String username) {
        userDao.deleteById(username);
    }

    public void deleteUserByName(String username) {
        userDao.delete(new QueryWrapper<UserPojo>().like("username", username));
    }

    public void findUserByName(String username) {
        List<UserPojo> pojo = userDao.selectList(new QueryWrapper<UserPojo>().like("username", username));
        pojo.forEach(item -> {
            System.out.println(item);
        });
    }

    public void updateUser(String username) {
        UserPojo pojo = userDao.selectById(username);
        pojo.setPassword("12121");
        userDao.update(pojo, new QueryWrapper<UserPojo>().eq("username", username));
    }
}