package com.cube.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Cube
 * @className MyAspect
 * @description
 * @date 2019-05-21 11:19
 */
@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.cube.service.impl.UserServiceImpl.addUser())")
    public void beforeNotify() {
        System.out.println("-----前置通知-----");
    }

    @AfterReturning(value = "execution(* com.cube.service.impl.UserServiceImpl.updateUser(..))", returning = "result")
    public void afterNotify(int result) {
        System.out.println("-----后置通知:" + result);
    }

    @After("execution(* com.cube.service.impl.UserServiceImpl.selectUser())")
    public void afterFinalNotify() {
        System.out.println("-----最终通知-----");
    }

    @AfterThrowing(value = "execution(* com.cube.service.impl.UserServiceImpl.selectUserById())", throwing = "ex")
    public void afterThrowingNotify(Exception ex) {
        ex.printStackTrace();
        System.out.println("-----异常通知-----");
    }

    @Around("execution(* com.cube.service.impl.UserServiceImpl.deleteUser())")
    public Object aroundNotify(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----环绕通知之前-----");
        System.out.println(System.currentTimeMillis());
        Object proceed = joinPoint.proceed();
        System.out.println("-----环绕通知之后-----");
        System.out.println(System.currentTimeMillis());

        return proceed;
    }
}
