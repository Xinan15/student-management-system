package com.example.springbootdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// pojo  相当于 entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class UserPojo {
    // TableId 标识主键
    @TableId(value = "username", type = IdType.NONE)
    private String username;

    // TableField 标识字段/列
    @TableField(value = "password")
    private String password;
}