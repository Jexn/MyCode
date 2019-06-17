package com.cube.Dao;

import com.cube.bean.User;

import java.util.List;

public interface IUserDao {

    List<User> findAllUser();

    User findUserById(Integer id);
}
