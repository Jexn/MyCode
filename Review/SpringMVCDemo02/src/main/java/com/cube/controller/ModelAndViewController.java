package com.cube.controller;

import com.cube.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO：
 * author：Cube
 * create：2019-06-28 08:59
 */
@Controller
@RequestMapping("/mv")
public class ModelAndViewController {

    @RequestMapping("returnModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("ModelAndView执行了");

        User user = new User("老赵","机智的老赵",19);
        modelAndView.addObject("user",user);

        modelAndView.setViewName("modelAndView");
        return modelAndView;
    }
}
