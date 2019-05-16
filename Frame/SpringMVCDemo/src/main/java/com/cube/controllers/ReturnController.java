package com.cube.controllers;

import com.cube.bean.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cube
 * @className ReturnController
 * @description
 * @date 2019-05-11 10:57
 */
@Controller
@RequestMapping("/returnResult")
public class ReturnController {

    // 跳转内部资源
    @RequestMapping("/string")
    public String returnString(){
        return "string";
    }

    // 跳转外部资源
    @RequestMapping("/external")
    public String returnExternalResource(){
        return "cube";
    }

    // 利用Model传递数据，String跳转资源
    @RequestMapping("/model")
    public String returnModel(String name, Model model){
        model.addAttribute(name);  // 这种写法相当于model.addAttribute("string",name)，根据name参数类型取名
        model.addAttribute("username",name);
        return "model";
    }

    // 返回void，实现servlet类型跳转
    @RequestMapping("/void")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Views/RequestDispatcher.jsp").forward(request,response);
    }

    // 处理Ajax请求，返回JSON
    @RequestMapping("/ajax")
    public void returnAjax(User user,HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String result = gson.toJson(user);
        out.write(result);
    }

    // 处理Ajax请求，返回Object对象
    @RequestMapping(value = "/object",produces = "text/html;charset=utf-8")
    @ResponseBody    // 必须添加，否则会去查找相应的jsp
    public Object returnObject(){
        System.out.println("return Object");
        return "返回对象";
    }

    // 处理Ajax请求，返回Map
    @RequestMapping("/map")
    @ResponseBody
    public Object returnMap(){
        Map<String,String> map = new HashMap<>();
        map.put("hello","你好");
        map.put("world","世界");
        map.put("book","书籍");
        return map;
    }
}
