package com.cube.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Cube
 * @className MyBeanPostProcessor
 * @description Bean后处理器
 * @date 2019-05-20 11:01
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessBeforeInitialization方法");
        // 此处必须返回bean，否则无法继续执行
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("studentService".equals(beanName)) {
            // 创建InvocationHandler对象
            InvocationHandler invocationHandler = ((Object object, Method method, Object[] args) -> {
                if ("study".equals(method.getName())) {
                    System.out.println("代理模式：目标方法开始执行");
                    Object result = method.invoke(bean, args);
                    System.out.println("代理模式：目标方法执行完成");
                    return result;
                }
                return method.invoke(bean, args);
            });
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), invocationHandler);
            System.out.println("执行postProcessAfterInitialization方法");
            return proxy;
        }
        return bean;
    }
}
