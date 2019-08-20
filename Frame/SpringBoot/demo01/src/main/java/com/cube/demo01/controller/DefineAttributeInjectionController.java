package com.cube.demo01.controller;

import com.cube.demo01.bean.OutsideFile;
import com.cube.demo01.bean.PersonConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO：application.properties自定义属性自动注入
 * author：Cube
 * create：2019-07-04 09:13
 */
@Controller
public class DefineAttributeInjectionController {
    @Value("${person.name}")
    private String name;
    @Value("${person.sex}")
    private String sex;
    @Value("${person.address}")
    private String address;
    @Value("${person.age}")
    private int age;

    private final PersonConfigInfo info;

    private final OutsideFile user;

    public DefineAttributeInjectionController(PersonConfigInfo info, OutsideFile user) {
        this.info = info;
        this.user = user;
    }

    @RequestMapping("/person")
    @ResponseBody
    public String getInfo() {
        System.out.println(info);
        System.out.println(user);
        return name + "," + sex + "," + address + "," + age;
    }

}
