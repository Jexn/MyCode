package Projects.EmployeeProject;

/**
 * @cLassName: SalariedEmployee
 * @author: cube
 * @description: TODO
 * @date: 2019/3/25 19:08
 */
public class SalariedEmployee extends Employee {
    private int monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    int earnings() {
        return this.monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "Name=" + super.getName() + ",id=" + super.getNumber() + ",birthday=" + super.getBirthday() +
                ",monthlySalary=" + monthlySalary +
                '}';
    }
}
