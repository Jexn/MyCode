package Day15;

import org.junit.Test;

import java.util.*;

public class SetTest {
    @Test
    public void hashSetTest() {
        Set set = new HashSet();

        set.add(21);
        set.add(12);
        set.add("Set");
        set.add("HashSet");
        set.add(new Person("Jack", 10));

        for (Object o : set) {
            System.out.println(o);
        }
    }

    /**
     * 外部排序,定制排序
     */
    @Test
    public void comparatorTest() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Customer && o2 instanceof Customer) {
                    Customer customer1 = (Customer) o1;
                    Customer customer2 = (Customer) o2;

                    int value = customer1.getAge() - customer2.getAge();
                    if (value != 0) {
                        return value;
                    } else {
                        return customer1.getName().compareTo(customer2.getName());
                    }
                }
                return 0;
            }
        };

        Set set = new TreeSet(comparator);
        set.add(new Customer("Tom", 10));
        set.add(new Customer("Jerry", 8));
        set.add(new Customer("Cafe", 5));
        set.add(new Customer("Mike", 20));
        set.add(new Customer("Jane",10));

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
