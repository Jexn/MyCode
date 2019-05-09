package Projects.GenericsProject.Employee;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTest {
    @Test
    public void employeeTest(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof MyDate && o2 instanceof MyDate){
                    MyDate myDate1 = (MyDate) o1;
                    MyDate myDate2 = (MyDate) o2;
                    int year = myDate1.getYear() - myDate2.getYear();
                    int month = myDate1.getMonth() - myDate2.getMonth();
                    int day = myDate1.getDay() - myDate2.getDay();
                    return year == 0 ? (month == 0 ? (day == 0 ? 0:day):month):year;
                }
                return 0;
            }
        };

        TreeSet<Employee> treeSet1 = new TreeSet<>();
        Employee employee1 = new Employee("刘德华",41,new MyDate(1978,10,10));
        Employee employee2 = new Employee("张学友",50,new MyDate(1975,10,9));
        Employee employee3 = new Employee("古天乐",43,new MyDate(1977,10,8));
        Employee employee4 = new Employee("杨幂",34,new MyDate(1986,10,7));

        treeSet1.add(employee1);
        treeSet1.add(employee2);
        treeSet1.add(employee3);
        treeSet1.add(employee4);

        for (Employee employee : treeSet1) {
            System.out.println(employee);
        }

        TreeSet<MyDate> treeSet2 = new TreeSet<>(comparator);
        MyDate date1 = new MyDate(1991,10,1);
        MyDate date2 = new MyDate(1989,9,1);
        MyDate date3 = new MyDate(1991,8,1);
        MyDate date4 = new MyDate(1993,10,9);
        MyDate date5 = new MyDate(1988,12,1);

        treeSet2.add(date1);
        treeSet2.add(date2);
        treeSet2.add(date3);
        treeSet2.add(date4);
        treeSet2.add(date5);

        for (MyDate myDate : treeSet2) {
            System.out.println(myDate);
        }

    }
}
