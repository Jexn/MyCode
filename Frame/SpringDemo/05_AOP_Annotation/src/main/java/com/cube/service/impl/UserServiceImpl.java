package com.cube.service.impl;

import com.cube.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Cube
 * @className UserServiceImpl
 * @description
 * @date 2019-05-21 11:16
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void selectUserById(int id) throws Exception {
        if (id == 0){
            throw new Exception("查找异常");
        }
    }

    @Override
    public int updateUser() {
        System.out.println("更新用户");
        return 999;
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }

    @Override
    public void selectUser() {
        System.out.println("查找所有用户");
    }
}
