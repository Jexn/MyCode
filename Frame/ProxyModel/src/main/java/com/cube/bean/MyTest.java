package com.cube.bean;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-05-19 10:08
 */
public class MyTest {

    @Test
    public void staticProxy() {
        Girl liuYiFei = new Girl("刘亦菲");
        IntermediaryPerson RiTa = new IntermediaryPerson("Rita", liuYiFei);
        Boy boy = new Boy("老王", RiTa);
        boy.makeFriend();
    }

    @Test
    public void dynamicProxy() {
        final Girl liuYiFei = new Girl("刘亦菲");

        /*
         * JDK自带的动态代理要求被代理对象实现了一个接口
         * Proxy.newProxyInstance()接收三个参数，①被代理类的类加载器；②被代理类的接口；③代理方法
         */
        Beauty beauty = (Beauty) Proxy.newProxyInstance(liuYiFei.getClass().getClassLoader(), liuYiFei.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * Object proxy:当前JDK创建的动态引用，在这个实例指向liuYiFei这个对象
             * Method method：被代理类需要被调用的方法，此方法指向eat()方法
             * Object[] args：调用方法的参数，此处的eat()方法参数为空，所以此时为空
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("打扮一下");
                Object invoke = method.invoke(liuYiFei);
                System.out.println("结果");
                return invoke;
            }
        });

        Boy boy = new Boy("老王", beauty);
        boy.makeFriend();
    }

    @Test
    public void dynamicProxy02() {
        Girl liuYiFei = new Girl("刘亦菲");
        Beauty beauty = (Beauty) Proxy.newProxyInstance(liuYiFei.getClass().getClassLoader(), liuYiFei.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                if ("eat".equals(method.getName())){
                    System.out.println("打扮一下");
                    invoke = method.invoke(liuYiFei);
                    System.out.println("吃饭完唱歌");
                }else if ("gift".equals(method.getName())){
                    System.out.println("赠送礼物");
                    invoke = method.invoke(liuYiFei,(Integer)args[0]/2);
                }
                return invoke;
            }
        });
        Boy boy = new Boy("老王",beauty);
        boy.sendGift(10);
        boy.makeFriend();
    }
}
