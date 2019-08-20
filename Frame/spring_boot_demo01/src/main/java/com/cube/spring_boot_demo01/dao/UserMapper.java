package com.cube.spring_boot_demo01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * TODO：
 * author：Cube
 * create：2019-07-03 08:16
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(account_id,name,token,GMT_Create,GMT_Modified) values(#{account_id},#{name},#{token},#{GMT_Create},#{GMT_Modified})")
    void inset(User user);

    @Select("select * from user where token = #{token}")
    User findUserByToken(String token);
}
