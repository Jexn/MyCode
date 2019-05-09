package Day15.Practice;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeTest {
    @Test
    public void myTest(){
        Set set = new TreeSet();
        set.add(new Employee("Tom",12,new MyDate(2000,1,10)));
        set.add(new Employee("Jerry",10,new MyDate(2002,1,12)));
        set.add(new Employee("Jane",10,new MyDate(2002,1,12)));

        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void comparatorTest(){
        MyDateComparator comparator = new MyDateComparator();
        Set set = new TreeSet(comparator);
        set.add(new Employee("Tom",12,new MyDate(2000,1,10)));
        set.add(new Employee("Jerry",10,new MyDate(2002,1,12)));
        set.add(new Employee("Jane",10,new MyDate(2002,1,12)));

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
