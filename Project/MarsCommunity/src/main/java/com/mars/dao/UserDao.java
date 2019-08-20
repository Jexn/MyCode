package com.mars.dao;

import com.mars.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void saveUser(User user);
    void deleteUser(Integer id);
    User findUserById(Integer id);
    List<User> findAllUser();
}
