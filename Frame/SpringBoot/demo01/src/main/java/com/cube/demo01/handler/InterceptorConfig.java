package com.cube.demo01.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO：
 * author：Cube
 * create：2019-07-04 10:46
 */
// @Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new DefineHandler());

        // 拦截器作用位置
        registration.addPathPatterns("/boot/*");

        // 拦截器不起作用位置
        registration.excludePathPatterns("/person");
    }
}
