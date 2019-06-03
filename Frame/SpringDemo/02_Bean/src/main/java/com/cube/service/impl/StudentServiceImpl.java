package com.cube.service.impl;

import com.cube.service.StudentService;

/**
 * @author Cube
 * @className StudentServiceImpl
 * @description
 * @date 2019-05-20 09:12
 */
public class StudentServiceImpl implements StudentService {

    public StudentServiceImpl() {
        System.out.println("StudentServiceImpl构造方法");
    }

    public void init(){
        System.out.println("Bean初始化");
    }

    @Override
    public void study() {
        System.out.println("好好学习，天天向上");
    }

    public void destroy(){
        System.out.println("Bean销毁");
    }
}
