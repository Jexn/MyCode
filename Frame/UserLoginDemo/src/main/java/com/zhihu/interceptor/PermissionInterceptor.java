package com.zhihu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cube
 * @className PermissionInterceptor
 * @description 权限拦截器
 * @date 2019-05-13 11:11
 */
public class PermissionInterceptor implements HandlerInterceptor {
    private static List<String> passList = null;
    static {
        passList = new ArrayList<>();
        passList.add("root");
        passList.add("admin");
        passList.add("guest");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = (String) request.getSession().getAttribute("user");
        if (!passList.contains(user)){
            request.setAttribute("msg","登录失败");
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
            return false;
        }else {
            request.getRequestDispatcher("/welcome");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
