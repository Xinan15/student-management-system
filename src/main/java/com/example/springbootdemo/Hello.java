package com.example.springbootdemo;

import org.springframework.stereotype.Component;

// @Component 注解 - 可以被机器识别 - 意思是可以被 Spring 扫描到 - 可以被 Spring 容器管理
@Component
class Hello {
    public static void say(){
        System.out.println("Hello World");
    }
}
