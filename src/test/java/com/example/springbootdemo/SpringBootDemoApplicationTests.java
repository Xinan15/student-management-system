package com.example.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springbootdemo.service.UserServiceImpl;

/* test 文件夹里面就是 测试代码 / 单元测试 */
@SpringBootTest
class SpringBootDemoApplicationTests {

	// @Autowired 依赖注入 - 可以自动将容器中的 Bean 注入到这里
	// Autowire - 自动装配
	@Autowired
	Hello hello;

	@Test
	void contextLoads() {
		hello.say();
	}

	@Autowired
	UserServiceImpl userService;

	@Test
	void testAddUser() {
		userService.addUser("ABC", "123456");
	}
}
