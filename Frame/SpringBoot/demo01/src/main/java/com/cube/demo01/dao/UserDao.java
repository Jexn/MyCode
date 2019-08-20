package com.cube.demo01.dao;

import com.cube.demo01.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO：
 * author：Cube
 * create：2019-07-04 10:06
 */
@Mapper
public interface UserDao {
    User findById(Integer id);
    List<User> findAllUser();
}
