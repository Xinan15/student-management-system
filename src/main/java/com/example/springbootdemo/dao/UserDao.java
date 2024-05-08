package com.example.springbootdemo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.pojo.UserPojo;

@Mapper
// Dao 层 - 数据访问层 - Mapper 层
// @Mapper 注解 - 可以被机器识别 - 意思是可以被 MyBatis 扫描到 - 可以被 MyBatis 管理
public interface UserDao extends BaseMapper<UserPojo>{
}


