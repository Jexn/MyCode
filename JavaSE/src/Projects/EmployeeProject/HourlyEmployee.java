package Projects.EmployeeProject;

/**
 * @cLassName: HourlyEmployee
 * @author: cube
 * @description: TODO
 * @date: 2019/3/25 19:15
 */
public class HourlyEmployee extends Employee {
    private int wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    int earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "Name=" + super.getName() + ",id=" + super.getNumber() + ",birthday=" + super.getBirthday() + "Daily salary:" + this.earnings() + '}';
    }
}
