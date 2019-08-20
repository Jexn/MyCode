package com.mars.services;

import com.mars.bean.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void deleteUser(Integer id);
    User findUserById(Integer id);
    List<User> findAllUser();
}
