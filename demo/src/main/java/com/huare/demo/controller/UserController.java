package com.huare.demo.controller;

import com.huare.demo.entity.User;
import com.huare.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2019年11月20日 16:06
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    public User findById(Integer id){
        return userService.findById(id);
    }
}
