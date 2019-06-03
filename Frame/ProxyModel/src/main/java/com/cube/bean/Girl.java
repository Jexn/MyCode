package com.cube.bean;

/**
 * @author Cube
 * @className Girl
 * @description 被代理的对象
 * @date 2019-05-19 10:00
 */
public class Girl implements Beauty{
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name+"吃饭");
    }

    @Override
    public void gift(int count) {
        System.out.println("收到"+count+"个礼物");
    }
}
