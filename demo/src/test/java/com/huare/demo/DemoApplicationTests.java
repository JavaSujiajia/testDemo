package com.huare.demo;

import com.huare.demo.entity.User;
import com.huare.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        User byId = userService.findById(1);
        System.out.println(byId.toString());
    }

    @Test
    public void test01(){
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
