package com.cube.beans;

/**
 * @author Cube
 * @className Hello
 * @description
 * @date 2019-06-12 09:06
 */
public class Hello {
    private String name;

    public Hello() {
        System.out.println("无参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("Hello,"+this.name);
    }
}
