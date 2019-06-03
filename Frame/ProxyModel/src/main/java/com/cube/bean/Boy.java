package com.cube.bean;

/**
 * @author Cube
 * @className Boy
 * @description 执行代理的对象
 * @date 2019-05-19 10:02
 */
public class Boy {
    private String name;
    private Beauty beauty;

    public Boy(String name, Beauty beauty) {
        this.name = name;
        this.beauty = beauty;
    }

    public void makeFriend(){
        System.out.println(name+"请吃饭");
        beauty.eat();
    }

    public void sendGift(int count){
        beauty.gift(count);
    }
}
