package com.cube.controller;

import com.cube.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO：
 * author：Cube
 * create：2019-06-28 10:08
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @RequestMapping("ajax01")
    public @ResponseBody User ajaxRequest(@RequestBody User user){
        System.out.println(user);

        User jcw = new User("金城武","jcw",40);
        return jcw;
    }
}
