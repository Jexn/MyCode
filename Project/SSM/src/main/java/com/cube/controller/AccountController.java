package com.cube.controller;

import com.cube.bean.Account;
import com.cube.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("findAllAccount")
    public ModelAndView findAllAccount(){
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accounts = accountService.findAllAccount();
        modelAndView.addObject("accounts",accounts);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("addAccount")
    public ModelAndView addAccount(Account account){
        ModelAndView modelAndView = new ModelAndView();
        accountService.addAccount(account);
        modelAndView.setViewName("redirect:/account/findAllAccount");
        return modelAndView;
    }
}
