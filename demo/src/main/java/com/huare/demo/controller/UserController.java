package com.huare.demo.controller;

import com.alibaba.fastjson.JSON;
import com.huare.demo.args.UserArgs;
import com.huare.demo.entity.User;
import com.huare.demo.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
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

    protected static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 如果需要使用此方法  要调用引入 import com.huare.demo.core.utils.Logger;
     * <p>
     * protected Logger logger = Logger.getLogger(this.getClass());
     */

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("findById")
    @ApiOperation("根据id查询User")
    public User findById(@RequestBody UserArgs userArgs) {
        logger.info("根据id查询User,访问参数:" + JSON.toJSONString(userArgs));
        return userService.findById(userArgs.getId());
    }

    /*
    @PostMapping("findByIdForID")
    @ApiOperation("根据id查询User")
    public User findByIdPar(@RequestBody int userID) {
        logger.info("根据id查询User,访问参数:" + JSON.toJSONString(userID));
        return userService.findById(userID);
    }*/

    @PostMapping("insertUserInfo")
    @ApiOperation("用户添加--UserInfo")
    public String insertUserInfo(@RequestBody UserArgs userArgs) {
        User user = new User();
        BeanUtils.copyProperties(userArgs, user);
        int i = userService.insertUser(user);
        return "数据成功插入[" + i + "]行:" + JSON.toJSONString(user);
    }
}
