package Day21;

import java.io.Serializable;

public class Person<T> extends Animal<String> implements Comparable, Serializable {
    private String name;
    public int age;
    T id;
    protected String local;

    public Person() {
        super("animal");
        System.out.println("none property!");
    }

    private Person(String name) {
        super("animal");
        this.name = name;
    }

    public Person(String name, int age) {
        super("animal");
        this.name = name;
        this.age = age;
    }

    protected Person(String name, T id, String local) {
        super("animal");
        this.name = name;
        this.id = id;
        this.local = local;
    }

    public void show() {
        System.out.println("name:" + name + ",age:" + age);
    }

    private void display() {
        System.out.println("私有方法");
    }

    public void setLocal(String local){
        this.local = local;
        System.out.println("当前地址："+local);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            return this.name.compareTo(person.name);
        }
        return 0;
    }
}
