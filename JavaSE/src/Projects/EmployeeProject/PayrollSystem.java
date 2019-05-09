package Projects.EmployeeProject;

import java.util.Calendar;

/**
 * @cLassName: PayrollSystem
 * @author: cube
 * @description: TODO
 * @date: 2019/3/25 19:17
 */
public class PayrollSystem {
    private Employee[] employees;
    private static int index = 0;

    public PayrollSystem(int num) {
        this.employees = new Employee[num];
    }

    public void getEmployeeInfo() {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
                if (employee.getBirthday().getMonth() == currentMonth) {
                    if (employee instanceof SalariedEmployee) {
                        System.out.println("本月生日奖金：500");
                    }
                }
            }
        }
    }

    public void addEmployee(Employee employee) {
        if (index < employees.length) {
            employees[index] = employee;
            index++;
        }
    }

    public void removeEmployee(int index) {
        if (index < employees.length) {
            employees[index] = null;
        } else {
            System.out.println("没有这个员工");
        }
    }
}
