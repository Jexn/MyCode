package com.cube.controllers;

import com.cube.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * @author Cube
 * @className ExceptionController
 * @description
 * @date 2019-05-12 10:47
 */
@Controller
public class ExceptionController {

    @RequestMapping("/error")
    public ModelAndView myException (String name) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        if ("jack".equals(name)){
            System.out.println("jack Exception");
            throw new MyException("自定义异常");
        }

        if ("root".equals(name)){
            System.out.println("root Exception");
            throw new Exception("异常");
        }

        return modelAndView;
    }
}
