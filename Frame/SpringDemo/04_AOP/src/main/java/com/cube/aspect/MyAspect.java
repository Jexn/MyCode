package com.cube.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Cube
 * @className MyAspect
 * @description
 * @date 2019-05-21 11:19
 */
public class MyAspect {

    public void beforeNotify(){
        System.out.println("-----前置通知-----");
    }

    public void afterNotify(int result){
        System.out.println("-----后置通知:"+result);
    }

    public void afterFinalNotify(){
        System.out.println("-----最终通知-----");
    }

    public void afterThrowingNotify(Exception ex){
        ex.printStackTrace();
        System.out.println("-----异常通知-----");
    }

    public Object aroundNotify(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----环绕通知之前-----");
        Object proceed = joinPoint.proceed();
        System.out.println("-----环绕通知之后-----");

        return proceed;
    }
}
