package com.cube.controllers;

import com.cube.bean.School;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cube
 * @className ForwardStringController
 * @description
 * @date 2019-05-11 18:41
 */
@Controller
public class ForwardStringController {

    // 返回String类型的转发
    // 如果携带了参数，则会默认把参数放到HttpServletRequest域中
    @RequestMapping("/forwardString")
    public String ForwardString(String name, School school){
        System.out.println(name);
        return "forward:/WEB-INF/Views/StringForward.jsp";
    }

    // 返回String类型的重定向
    @RequestMapping("/redirectString")
    public String redirectString(Model model,School school){

        // 数据会放到url中，因此只能传递基本数据类型
        model.addAttribute("name",school.getSchool_name());
        model.addAttribute("local",school.getLocal());

        return "redirect:/RedirectString.jsp";
    }
}
