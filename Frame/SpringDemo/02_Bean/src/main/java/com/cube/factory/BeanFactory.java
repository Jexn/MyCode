package com.cube.factory;

import com.cube.service.StudentService;
import com.cube.service.impl.StudentServiceImpl;

/**
 * @author Cube
 * @className BeanFactory
 * @description 实例模式
 * @date 2019-05-20 10:36
 */
public class BeanFactory {
    public StudentService createStudentServiceImpl(){
        return new StudentServiceImpl();
    }
}
