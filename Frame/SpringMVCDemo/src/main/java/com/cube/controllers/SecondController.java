package com.cube.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cube
 * @className SecondController
 * @description 注解式配置
 * @date 2019-05-10 15:44
 */
@Controller
@RequestMapping("/test")   // 表示命名空间，可以不写，如果写了，访问以下链接需要添加/test，例如/test/second，/test/request1,/test/request2
public class SecondController {

    @RequestMapping("/second")
    public ModelAndView second(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("annotation", "注解式配置");
        modelAndView.setViewName("second");
        return modelAndView;
    }

    // 对应多个请求
    @RequestMapping({"/request1", "/request2"})
    public ModelAndView multiRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("annotation", "对应多个请求,multiRequest");
        modelAndView.setViewName("second");
        return modelAndView;
    }

    /*
    请求中携带的参数
    在RequestMapping中还有一个属性是params，通过这个属性我们可以指定请求中必须携带的参数。

    @RequestMapping(value="/test.do" ,  params={"name" , "age"})
    要求请求中必须携带请求参数 name 与 age

    @RequestMapping(value="/test.do" , params={"!name" , "age"})
    要求请求中必须携带请求参数 age，但必须不能携带参数 name

    @RequestMapping(value="/test.do" , params={"name=jack" , "age=23"})
    要求请求中必须携带请求参数 name，且其值必须为jack；必须携带参数 age，其值必须为 23

    @RequestMapping(value="/test.do" , params="name!=jack")
    要求请求中必须携带请求参数name，且其值必须不能为jack
    */

    // 设置只接受POST请求，并且携带指定参数，age必须，name可选
    @RequestMapping(value = "/postRequest", method = RequestMethod.POST, params = {"!name", "age"})
    public ModelAndView postRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("annotation", "设置POST请求");
        modelAndView.setViewName("second");
        return modelAndView;
    }

    // 设置只接受get请求，并且携带指定参数
    @RequestMapping(value = "/getRequest", method = RequestMethod.GET, params = {"name", "age"})
    public ModelAndView getRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("annotation", "设置GET请求");
        modelAndView.setViewName("second");
        return modelAndView;
    }
}
