package com.cube.demo01.controller;

import com.cube.demo01.bean.User;
import com.cube.demo01.dao.UserDao;
import com.cube.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO：FirstController
 * author：Cube
 * create：2019-07-04 08:42
 */
@Controller
@RequestMapping("/boot")
public class FirstController {

    @Autowired
    private UserService userService;

    @RequestMapping("first")
    public String first(){
        return "first";
    }

    @RequestMapping("findById")
    @ResponseBody
    public String findById(){
        User user = userService.findById(1);
        return user.toString();
    }
}
