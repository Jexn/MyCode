package Day10.Polymorphism_1;

import java.util.Objects;

/**
 * @cLassName: Man
 * @author: cube
 * @description: TODO
 * @date: 2019/3/24 10:22
 */
public class Man extends Person {
    int id;
    String sex;

    public Man() {
        this.id = 1001;
        this.sex = "man";
    }

    @Override
    public void say() {
        System.out.println("Man Speak!");
    }

    @Override
    public void walk() {
        System.out.println("男人跑得快");
    }

    public void getMoney() {
        System.out.println("男人应当挣钱养家");
    }

}
