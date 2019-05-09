package Day10.Polymorphism_1;

/**
 * @cLassName: Person
 * @author: cube
 * @description: TODO
 * @date: 2019/3/24 10:20
 */
public class Person {
    int id;

    public Person(){
        this.id = 1000;
    }

    public Person(int id) {
        this.id = id;
    }

    public void say(){
        System.out.println("Person can speak!");
    }

    public void walk(){
        System.out.println("Person can walk!");
    }
}
