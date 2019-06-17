package com.cube.Dao;

import com.cube.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description：持久层
 * author：Cube
 * create：2019-06-15 10:46
 */
public interface IUserDao {

    @Select("Select * from user")
    List<User> findAllUser();
}
