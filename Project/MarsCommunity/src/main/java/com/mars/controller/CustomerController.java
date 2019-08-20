package com.mars.controller;

import com.alibaba.fastjson.JSON;
import com.mars.bean.Customer;
import com.mars.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 获取所有客户
    @GetMapping(value = "/allCustomer", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findAllCustomer() {
        List<Customer> customers = customerService.findAllCustomer();
        return JSON.toJSONString(customers);
    }

    // 根据ID查找客户
    @GetMapping(value = "/getCustomer/{id}",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.findCustomerById(id);
        System.out.println(id);
        System.out.println(customer);
        return JSON.toJSONString(customer);
    }

    //新增客户
    @PostMapping("/addUser")
    public String saveCustomer(Customer customer) {
        System.out.println(customer);
        customerService.saveCustomer(customer);
        return "list";
    }

    // 修改客户
    @PostMapping("/modify/{id}")
    public String updateCustomer(@PathVariable Integer id, @ModelAttribute Customer customer) {
        System.out.println(customer);
        customer.setId(id);
        customerService.modifyCustomer(customer);
        return "list";
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "list";
    }

    // 跳转到修改页面
    @GetMapping("/modify/{id}")
    public String redirect(@PathVariable Integer id, Model model){
        model.addAttribute("userId",id);
        return "modify";
    }

    // 跳转到添加页面
    @GetMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

}
