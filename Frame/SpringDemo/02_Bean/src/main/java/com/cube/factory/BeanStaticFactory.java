package com.cube.factory;

import com.cube.service.StudentService;
import com.cube.service.impl.StudentServiceImpl;

/**
 * @author Cube
 * @className BeanStaticFactory
 * @description 静态工厂装载
 * @date 2019-05-20 10:39
 */
public class BeanStaticFactory {
    public static StudentService createStudentServiceImpl(){
        return new StudentServiceImpl();
    }
}
