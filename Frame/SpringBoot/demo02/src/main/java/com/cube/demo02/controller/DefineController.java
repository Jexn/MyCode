package com.cube.demo02.controller;

import com.cube.demo02.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO：
 * author：Cube
 * create：2019-07-04 15:05
 */
@Controller
public class DefineController {

    @GetMapping("/hello")
    public String helloThymeleaf(Model model){
        model.addAttribute("name","jack");
        return "index";
    }

    @GetMapping("/userInfo")
    public String userInfo(Model model){
        User user = new User(1,"老王","男",20,"1888888888","北京市中南海");
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/listUser")
    public String listUser(Model model){
        List<User> users = new ArrayList<>();
        for (int i = 1 ; i <= 15; i++){
            User user = new User(i,"user_"+i,"男",(int)(Math.random()*100),"1880000000"+i,"北京市中南海");
            users.add(user);
        }
        model.addAttribute("users",users);
        return "users";
    }
}
