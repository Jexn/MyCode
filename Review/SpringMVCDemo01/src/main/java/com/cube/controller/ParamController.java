package com.cube.controller;

import com.cube.bean.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO：数据请求
 * author：Cube
 * create：2019-06-19 15:14
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/request1")
    public String requestDateHandle(String username){
        System.out.println("接收到的用户名："+username);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }
}
