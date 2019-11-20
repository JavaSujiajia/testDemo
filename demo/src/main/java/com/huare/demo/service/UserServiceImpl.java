package com.huare.demo.service;

import com.huare.demo.core.service.BaseService;
import com.huare.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2019年11月20日 16:01
 */
@Service
public class UserServiceImpl extends BaseService<User> {

    public User findById(Integer id) {
        return super.findById(id);
    }
}
