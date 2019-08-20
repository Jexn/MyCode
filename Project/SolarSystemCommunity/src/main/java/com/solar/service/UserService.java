package com.solar.service;

import com.solar.pojo.User;

import java.util.List;

public interface UserService {
    User findUserByName(String name);
    User findUserById(Integer id);
    void updateUserInfo(User user);
    void deleteUserById(Integer id);
    void saveUser(User user);
    List<User> findAllUser();
}
