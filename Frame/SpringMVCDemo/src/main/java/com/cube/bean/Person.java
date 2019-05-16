package com.cube.bean;

import javax.validation.constraints.*;

/**
 * @author Cube
 * @className Person
 * @description 数据校验
 * @date 2019-05-12 14:48
 */
public class Person {

    @NotEmpty(message = "用户姓名不能为空")
    @Size(min = 6,max = 16,message = "姓名长度必须在{min} - {max}之间")
    private String name;

    @Min(value = 0,message = "年龄不能小于{value}")
    @Max(value = 120,message = "年龄不能大于{value}")
    private int age;

    @Pattern(regexp = "^1([356789][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$",message = "请输入正确的手机号")
    private String phone;

    public Person(@NotEmpty(message = "用户姓名不能为空") @Size(min = 6, max = 16, message = "姓名长度必须在{max} - {min}之间") String name, @Min(value = 0, message = "年龄不能小于{value}") @Max(value = 120, message = "年龄不能大于{value}") int age, @Pattern(regexp = "^1([356789][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "请输入正确的手机号") String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
