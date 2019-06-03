package com.cube.bean;

import org.springframework.stereotype.Repository;

/**
 * @author Cube
 * @className UserImpl
 * @description
 * @date 2019-05-20 15:15
 */
@Repository("user")
public class UserImpl implements User {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
