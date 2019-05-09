package Day09.ExtendsDemo_1;

/**
 * @cLassName: Dog
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 9:42
 */
public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String getInfo() {
        return "Dog"+":"+super.getAge();
    }
}
