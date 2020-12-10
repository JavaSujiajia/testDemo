package com.huare.demo;

import com.alibaba.fastjson.JSON;
import com.huare.demo.entity.User;
import com.huare.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        User byId = userService.findById(1);
        System.out.println(byId.toString());
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setUsername("狗贼");
        user.setPassword("123456");
        int i = userService.insertUser(user);
        System.out.println("数据成功插入[" + i + "]行:" + JSON.toJSONString(user));
    }

    @Test
    void testFindByUsername() {
        List<User> userList = userService.findByUserName("zhangliu");
        System.out.println(JSON.toJSONString(userList));
    }


}
