package com.cube.service.impl;

import com.cube.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Cube
 * @className UserServiceImpl
 * @description
 * @date 2019-05-23 09:33
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
