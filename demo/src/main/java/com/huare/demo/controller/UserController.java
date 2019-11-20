package com.huare.demo.controller;

import com.huare.demo.args.UserArgs;
import com.huare.demo.entity.User;
import com.huare.demo.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2019年11月20日 16:06
 */
@RestController
@RequestMapping("user")
@Api(value = "用户操作-UserController")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("findById")
    @ApiOperation("根据id查询User")
    public User findById(@RequestBody UserArgs userArgs){
        return userService.findById(userArgs.getId());
    }
}
