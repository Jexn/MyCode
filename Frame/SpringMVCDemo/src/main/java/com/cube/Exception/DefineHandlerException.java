package com.cube.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cube
 * @className DefineHandlerException
 * @description 自定义异常处理
 * @date 2019-05-12 11:35
 */
public class DefineHandlerException implements HandlerExceptionResolver {
    /**
     * 自定义的异常处理可以省略Spring的配置
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ex",ex);
        modelAndView.setViewName("error");
        if (ex instanceof MyException){
            modelAndView.setViewName("defineError");
        }
        if (ex instanceof NullPointerException){
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
