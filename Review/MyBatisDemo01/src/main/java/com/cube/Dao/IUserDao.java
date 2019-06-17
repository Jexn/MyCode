package com.cube.Dao;

import com.cube.bean.QueryVO;
import com.cube.bean.User;

import java.util.List;

/**
 * @Name IUserDao
 * @Description 用户持久层
 * @User Cube
 * @Time 2019-06-15 09:20
 */
public interface IUserDao {

    List<User> findAllUser();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findUserById(Integer id);

    List<User> findUserByName(String userName);

    int findAllNum();

    List<User> findUserByQueryVO(QueryVO queryVO);
}
