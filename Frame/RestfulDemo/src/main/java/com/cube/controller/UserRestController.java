package com.cube.controller;

import com.alibaba.fastjson.JSON;
import com.cube.Util.DataUtil;
import com.cube.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Cube
 * @className UserRestController
 * @description Restful风格的CRUD
 * @date 2019-05-14 09:40
 */
@RestController
public class UserRestController {

    // 查询所有后台数据
    @GetMapping("/users")
    public String findAll() throws Exception {
        HashMap<String, User> allUser = DataUtil.findAll();
        return JSON.toJSONString(allUser);
    }

    // 根据ID查找用户
    @GetMapping("/users/{id}")
    public String findByID(@PathVariable String id) throws Exception {
        User user = DataUtil.findUserById(id);
        return JSON.toJSONString(user);
    }

    // 新增用户
    @PostMapping("/users")
    public String create(@RequestBody User user) {
        System.out.println(user);
        try {
            DataUtil.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }

    // 修改用户
    @PutMapping("/users/{id}")
    public String update(@PathVariable String id,@RequestBody User user){
        System.out.println(id);
        System.out.println(user);
        try {
            DataUtil.update(id,user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id){
        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }
}
