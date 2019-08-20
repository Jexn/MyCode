package com.cube.spring_boot_demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 初学Spring-Boot, "Whitelabel Error Page"是很多人碰到的第一个头痛的问题
 * Whitelabel Error Page
 * This application has no explicit mapping for /error, so you are seeing this as a fallback.
 *
 * Fri Apr 09 13:02:50 CST 2017
 * There was an unexpected error (type=Internal Server Error, status=500).
 * No message available
 *
 * 这一般是因为，通过Application无法找到controller造成的。
 *
 * 解决方式如下：
 *
 * 1. Application中需要在包结构的最上层
 * 2. Application中引入注解，并加上Controller的包目录 @ComponentScan(basePackages= {"org.xxxx.ad.controller"})
 * 3. Application上加入注解@SpringBootApplication
 * 4. Application扩展SpringBootServletInitializer
 * ---------------------
 * 作者：hannover100
 * 来源：CSDN
 * 原文：https://blog.csdn.net/hannover100/article/details/78084812
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@SpringBootApplication
public class SpringBootDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo01Application.class, args);
    }

}
