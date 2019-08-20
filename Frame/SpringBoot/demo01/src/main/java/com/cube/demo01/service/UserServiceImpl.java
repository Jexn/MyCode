package com.cube.demo01.service;

import com.cube.demo01.bean.User;
import com.cube.demo01.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO：Spring Boot开启事务支持
 * author：Cube
 * create：2019-07-04 10:24
 */
@Service
@Transactional // 开启事务
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
