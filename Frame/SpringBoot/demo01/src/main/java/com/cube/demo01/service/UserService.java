package com.cube.demo01.service;

import com.cube.demo01.bean.User;

import java.util.List;

/**
 * TODO：事务支持
 * author：Cube
 * create：2019-07-04 10:23
 */
public interface UserService {
    User findById(Integer id);
    List<User> findAllUser();
}
