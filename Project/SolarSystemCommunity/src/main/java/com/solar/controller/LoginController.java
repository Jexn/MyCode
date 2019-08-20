package com.solar.controller;

import com.solar.pojo.User;
import com.solar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public String Login(HttpSession session, String username, String password, boolean isRemember) {
        System.out.println(username + "-" + password + "-" + isRemember);
        User user = userService.findUserByName(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "/WEB-INF/Pages/home";
        }
        return "redirect:/static/index.html";
    }

    @GetMapping("logout")
    public String Logout(HttpSession session){
        session.invalidate();
        return "redirect:/static/index.html";
    }
}
