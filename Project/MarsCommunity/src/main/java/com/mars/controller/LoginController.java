package com.mars.controller;

import com.mars.bean.User;
import com.mars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public String login(Model model, User user){
        System.out.println(user);
        User resultUser = userService.findUserById(user.getId());
        if (resultUser != null && resultUser.getPassword().equals(user.getPassword())){
            model.addAttribute("user",resultUser);
            return "success";
        }else {
            return "redirect:/index.html";
        }
    }

    @RequestMapping("register")
    public String register(Model model,User user){
        userService.saveUser(user);
        model.addAttribute("user",user);
        return "success";
    }
}
