package Day16.Practice;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        Person person1 = new Person(1001,"AA");
        Person person2 = new Person(1002,"BB");

        System.out.println("person1.hashCode() = " + person1.hashCode());
        set.add(person1);
        set.add(person2);

        // 因为set里存储的是对象的引用地址，所以此时set你的person1的name会被修改
        person1.setName("CC");
        for (Object o : set) {
            System.out.println(o);
        }

        System.out.println();
        System.out.println("remove after:");

        System.out.println("person1.hashCode() = " + person1.hashCode());
        // remove的时候会再次计算需要删除对象的hashCode值，因为person1的值已经被修改，所以其hashCode已经被修改
        // 删除的时候查找其hashCode会发现没有相应的元素
        set.remove(person1);

        for (Object o : set) {
            System.out.println(o);
        }

        Person person = new Person(1001,"CC");
        System.out.println("person.hashCode() = " + person.hashCode());
        set.add(person);

        System.out.println();
        for (Object o : set) {
            System.out.println(o);
        }

        person = new Person(1001,"AA");
        System.out.println("person.hashCode() = " + person.hashCode());
        set.add(person);

        System.out.println();
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
