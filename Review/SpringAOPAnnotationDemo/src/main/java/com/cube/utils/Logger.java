package com.cube.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Cube
 * @className Logger
 * @description 记录执行日志
 * @date 2019-06-14 09:18
 */
@Component("logger")
@Aspect
public class Logger {

    /**
     * 这个方法只是为了定义切入点
     */
    @Pointcut("execution(* com.cube.service.AccountServiceImpl.*(..))")
    private void pointCut(){}

    /**
     * 用于打印日志：计划让其再切入点方法执行之前执行
     */
    // 前置通知
    @Before("pointCut()")
    public void printLog(){
        System.out.println("Logger类中printLog（）方法开始记录日志。。。");
    }

    // 有返回值通知
    @AfterReturning("pointCut()")
    public void afterReturningLog(){
        System.out.println("返回值通知");
    }

    // 异常通知
    @AfterThrowing("pointCut()")
    public void throwingLog(){
        System.out.println("异常通知");
    }

    // 最终通知
    @After("pointCut()")
    public void finalLog(){
        System.out.println("最终通知");
    }

    // 环绕通知
    @Around("pointCut()")
    public void roundLog(){
        System.out.println("环绕通知");
    }
}
