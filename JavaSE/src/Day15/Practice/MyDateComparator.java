package Day15.Practice;

import java.util.Comparator;

public class MyDateComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof  Employee && o2 instanceof Employee){
            Employee employee1 = (Employee) o1;
            Employee employee2 = (Employee) o2;

            int year = employee1.getBirthDay().getYear() - employee2.getBirthDay().getYear();
            int month = employee1.getBirthDay().getMonth() - employee2.getBirthDay().getMonth();
            int day = employee1.getBirthDay().getDay() - employee2.getBirthDay().getDay();
            if (year != 0){
                return year;
            }else {
                if (month != 0){
                    return month;
                }else {
                    if (day != 0){
                        return day;
                    }
                }
            }
        }
        return 0;
    }
}
