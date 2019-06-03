package com.cube.bean;

/**
 * @author Cube
 * @className IntermediaryPerson
 * @description 中间人对象
 * @date 2019-05-19 10:03
 */
public class IntermediaryPerson implements Beauty{
    private String name;
    // 闺蜜
    private Girl targetGirl;


    public IntermediaryPerson(String name, Girl targetGirl) {
        this.name = name;
        this.targetGirl = targetGirl;
    }

    @Override
    public void eat() {
        System.out.println(name+"做中间人");
        targetGirl.eat();
    }

    @Override
    public void gift(int count) {

    }
}
