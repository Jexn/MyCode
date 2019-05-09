package Day09.ExtendsDemo_1;

/**
 * @cLassName: Animal
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 9:41
 */
public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public Object getInfo(){
        return this.name+":"+this.age;
    }
}
