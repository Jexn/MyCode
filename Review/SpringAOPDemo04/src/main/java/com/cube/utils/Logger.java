package com.cube.utils;

/**
 * @author Cube
 * @className Logger
 * @description 记录执行日志
 * @date 2019-06-14 09:18
 */
public class Logger {
    /**
     * 用于打印日志：计划让其再切入点方法执行之前执行
     */

    // 前置通知
    public void printLog(){
        System.out.println("Logger类中printLog（）方法开始记录日志。。。");
    }

    // 后置通知
    public void afterLog(){
        System.out.println("日志记录结束");
    }

    // 有返回值通知
    public void afterReturningLog(){
        System.out.println("返回值通知");
    }

    // 异常通知
    public void throwingLog(){
        System.out.println("异常通知");
    }

    // 最终通知
    public void finalLog(){
        System.out.println("最终通知");
    }

}
