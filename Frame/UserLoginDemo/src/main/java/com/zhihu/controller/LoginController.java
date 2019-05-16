package com.zhihu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Cube
 * @className LoginController
 * @description 登录校验
 * @date 2019-05-13 11:03
 */
@Controller
public class LoginController {

    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("welcome","欢迎登录本系统");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping("/checkUser")
    public ModelAndView checkUser(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("user",username);
        modelAndView.setViewName("forward:/welcome");
        return modelAndView;
    }
}
