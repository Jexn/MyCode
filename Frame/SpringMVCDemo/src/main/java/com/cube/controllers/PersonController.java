package com.cube.controllers;

import com.cube.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Cube
 * @className PersonController
 * @description 数据校验
 * @date 2019-05-12 14:59
 */
@Controller
public class PersonController {

    // Validated不能加载String类型或基本类型前面
    // bindingResult获取所有验证异常信息
    @RequestMapping("/checkData")
    public ModelAndView register(@Validated Person person, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        // 数据校验失败
        if (!allErrors.isEmpty()) {
            FieldError nameError = bindingResult.getFieldError("name");
            FieldError ageError = bindingResult.getFieldError("age");
            FieldError phoneError = bindingResult.getFieldError("phone");

            if (nameError!=null){
                modelAndView.addObject("nameError",nameError.getDefaultMessage());
            }
            if (ageError!=null){
                modelAndView.addObject("ageError",ageError.getDefaultMessage());
            }
            if (phoneError!=null){
                modelAndView.addObject("phoneError",phoneError.getDefaultMessage());
            }
            modelAndView.setViewName("forward:/checkDataRegister.jsp");
            return modelAndView;
        }

        modelAndView.addObject("msg","注册成功");
        modelAndView.addObject("name",person.getName());
        modelAndView.addObject("age",person.getAge());
        modelAndView.addObject("phone",person.getPhone());

        modelAndView.setViewName("Person");
        return modelAndView;
    }

}
