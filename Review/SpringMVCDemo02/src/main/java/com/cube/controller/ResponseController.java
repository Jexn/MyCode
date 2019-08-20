package com.cube.controller;

import com.cube.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO：
 * author：Cube
 * create：2019-06-28 08:14
 */
@Controller
@RequestMapping("/response")
public class ResponseController {

    @RequestMapping("string")
    public String responseString() {
        System.out.println("返回字符串");
        return "success";
    }

    @RequestMapping("objectAttribute")
    public String responseObjectAttribute(Model model) {
        System.out.println("获取属性");
        User user = new User("老王", "没有密码", 20);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 默认没有指定返回，则自动根据视图解析器跳转至/WEB-INF/pages/voidDefault.jsp页面，如果没有这个页面则404报错
     */
    @RequestMapping("voidDefault")
    public void voidDefault() {
        System.out.println("默认请求");
    }

    /**
     * 利用servlet自定义转发路径。如果使用了自定义的转发，则SpringMVC的视图解析器将失效，需要写完整路径
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("voidDefined")
    public void voidDefined(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("自定义转发路径");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
    }

    @RequestMapping("voidRedirect")
    public void voidRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("重定向");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
