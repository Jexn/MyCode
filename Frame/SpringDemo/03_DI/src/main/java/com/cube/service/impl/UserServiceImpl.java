package com.cube.service.impl;

import com.cube.bean.User;
import com.cube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Cube
 * @className UserServiceImpl
 * @description
 * @date 2019-05-20 15:16
 */
// Scope注解设置类是否为单例
@Scope("singleton")
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "user")
    private User user;

    // Setter方式依赖注入必须有get/set方法
    // public User getUser() {
    //     return user;
    // }
    //
    // public void setUser(User user) {
    //     this.user = user;
    // }


    // public UserServiceImpl(User user) {
    //     this.user = user;
    // }

    @Override
    public void showUser() {
        user.addUser();
    }

    @PostConstruct
    public void before(){
        System.out.println("初始化");
    }

    @PreDestroy
    public void after(){
        System.out.println("销毁");
    }
}
