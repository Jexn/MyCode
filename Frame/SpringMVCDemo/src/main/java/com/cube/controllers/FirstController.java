package com.cube.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cube
 * @className FirstController
 * @description
 * @date 2019-05-10 12:08
 */
public class FirstController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test","SpringMVC测试");
        modelAndView.setViewName("first");
        return modelAndView;
    }
}
