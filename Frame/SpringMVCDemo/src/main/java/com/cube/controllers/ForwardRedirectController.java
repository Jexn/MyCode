package com.cube.controllers;

import com.cube.bean.Location;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Cube
 * @className RedirectController
 * @description
 * @date 2019-05-11 15:38
 */
@Controller
@RequestMapping("/redirect")
public class ForwardRedirectController {

    // 返回ModelAndView的转发
    @RequestMapping("/forward")
    public ModelAndView forwardMAV() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("type", "返回ModelAndView对象的转发");
        // 默认使用转发进行跳转
        modelAndView.setViewName("fromForward");

        //手动显式指定使用转发，此时springMvc.xml配置文件中的视图解析器将会失效
        // modelAndView.setViewName("forward:/WEB-INF/Views/fromForward.jsp");
        return modelAndView;
    }

    // 转发到其他Controller
    @RequestMapping("/forwardToController")
    public ModelAndView forwardToController() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("type", "ModelAndView实现转发跳转到其他的Controller");
        modelAndView.setViewName("forward:/redirect/other");
        return modelAndView;
    }

    @RequestMapping("/other")
    public ModelAndView otherController() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("other");
        return modelAndView;
    }

    // 重定向
    @RequestMapping("/redirect")
    public ModelAndView redirectMAV() {
        ModelAndView modelAndView = new ModelAndView();
        // ModelAndView重定向携带参数类似与get请求，会把参数拼接到转发的url，限制参数类型为/String或基本数据类型，不能携带自定义数据类型
        // 携带的参数在param域中
        modelAndView.addObject("type", "使用ModelAndView转发携带参数");
        modelAndView.setViewName("redirect:/redirect.jsp");
        return modelAndView;
    }

    // 重定向到其他Controller
    // 这种方式可以传递对象
    @RequestMapping("/redirectToController")
    public ModelAndView redirectToController() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("type", "redirect重定向携带的参数");
        modelAndView.addObject("name","中国");
        modelAndView.addObject("localInfo","广东");
        modelAndView.setViewName("redirect:/redirect/redirectSendObject");
        return modelAndView;
    }

    @RequestMapping("/redirectSendObject")
    public ModelAndView redirectObject(String type,String name,String localInfo){
        ModelAndView modelAndView = new ModelAndView();
        Location location = new Location(name,localInfo);
        modelAndView.addObject("type",type);
        modelAndView.addObject("location",location);
        modelAndView.setViewName("redirectObj");
        return modelAndView;
    }

}
