package com.cube.controllers;

import com.cube.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Cube
 * @className ParameterController
 * @description 接收参数
 * @date 2019-05-10 17:12
 */

@Controller
@RequestMapping("/user")
public class ParameterController {

    /**
     * SpringMVC的controller方法可以对以下五个参数自动赋值，HttpServletRequest和HttpServletResponse可以省略
     * 1.HttpServletRequest
     * 2.HttpServletResponse
     * 3.HttpSession
     * 4.请求携带的参数
     * 5.用于承载数据的Model
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST,params = {"username","age"})
    public ModelAndView parameter01(String username,int age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",username);
        modelAndView.addObject("age",age);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    // 前端表单参数name名称和方法参数不一致情况，defaultValue指定默认值
    @RequestMapping(value = "/register02")
    public ModelAndView parameter02(@RequestParam(name = "username") String name, @RequestParam(name = "age",defaultValue = "18") int p_age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.addObject("age",p_age);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    // 接收对象
    @RequestMapping(value = "/register03",method = RequestMethod.POST)
    public ModelAndView parameter03(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",user.getName());
        modelAndView.addObject("age",user.getAge());
        modelAndView.addObject("sex",user.getSex());
        modelAndView.addObject("email",user.getEmail());
        modelAndView.addObject("phone",user.getPhone());
        modelAndView.setViewName("PersonInfo");
        return modelAndView;
    }

    // 对象属性参数的接收
    @RequestMapping(value = "/register04",method = RequestMethod.POST)
    public ModelAndView parameter04(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",user.getName());
        modelAndView.addObject("age",user.getAge());
        modelAndView.addObject("locationName",user.getLocation().getName());
        modelAndView.addObject("locationInfo",user.getLocation().getLocalInfo());
        modelAndView.setViewName("simplePersonInfo");
        return modelAndView;
    }
}
