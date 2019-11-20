package com.huare.demo.dao;

import com.huare.demo.core.mybatis.BaseMapper;
import com.huare.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2019年11月20日 15:38
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
