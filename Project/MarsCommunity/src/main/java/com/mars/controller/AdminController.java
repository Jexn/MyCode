package com.mars.controller;

import com.mars.bean.Admin;
import com.mars.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("login")
    public String login(Model model,Admin admin){
        Admin returnAdmin = adminService.findAdminByUserName(admin.getUsername());
        if (returnAdmin != null && returnAdmin.getUsername().equals(admin.getPassword())){
            return "list";
        }else {
            model.addAttribute("message","用户名或密码错误");
            return "redirect:login.html";
        }
    }
}
