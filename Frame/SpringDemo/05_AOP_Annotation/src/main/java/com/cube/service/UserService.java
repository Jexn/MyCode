package com.cube.service;

/**
 * @author Cube
 * @className UserService
 * @description
 * @date 2019-05-21 11:14
 */
public interface UserService {
    void addUser();

    void selectUserById(int id) throws Exception;

    int updateUser();

    void deleteUser();

    void selectUser();
}
