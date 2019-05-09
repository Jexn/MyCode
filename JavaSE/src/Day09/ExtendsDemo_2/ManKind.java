package Day09.ExtendsDemo_2;

/**
 * @cLassName: ManKind
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 10:50
 */
public class ManKind {
    private String sex;
    private int salary;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWoman(){
        if ("man".equals(this.sex)){
            System.out.println("man");
        }else if ("woman".equals(this.sex)){
            System.out.println("woman");
        }else {
            System.out.println("unknown");
        }
    }

    public void employed(){
        if (this.salary == 0){
            System.out.println("no job");
        }else if (this.salary > 0){
            System.out.println("job");
        }else {
            System.out.println("go job");
        }
    }
}
