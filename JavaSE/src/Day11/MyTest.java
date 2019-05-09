package Day11;

import Projects.EmployeeProject.HourlyEmployee;
import Projects.EmployeeProject.MyDate;
import Projects.EmployeeProject.PayrollSystem;
import Projects.EmployeeProject.SalariedEmployee;
import org.junit.Test;

/**
 * @cLassName: MyTest
 * @author: cube
 * @description: TODO
 * @date: 2019/3/25 15:02
 */
public class MyTest {
    @Test
    public void test01() {
        SingletonModel_1 singletonModel_1 = SingletonModel_1.getInstance();
        SingletonModel_1 singletonModel_2 = SingletonModel_1.getInstance();

        System.out.println("(singletonModel_1 == singletonModel_2) = " + (singletonModel_1 == singletonModel_2));

    }

    @Test
    public void test02() {
        SingletonModel_2 singletonModel_1 = SingletonModel_2.getInstance();
        SingletonModel_2 singletonModel_2 = SingletonModel_2.getInstance();

        System.out.println(singletonModel_1 == singletonModel_2);
    }

    @Test
    public void employeeTest() {
        PayrollSystem payrollSystem = new PayrollSystem(100);
        payrollSystem.addEmployee(new SalariedEmployee("老王", 10001, new MyDate(1994, 3, 4), 4000));
        payrollSystem.addEmployee(new HourlyEmployee("老李", 10002, new MyDate(1990, 3, 10), 120, 8));
        payrollSystem.getEmployeeInfo();
    }
}
