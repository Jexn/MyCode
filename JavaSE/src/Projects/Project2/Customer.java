package Projects.Project2;

/**
 * @cLassName: Customer
 * @author: cube
 * @description: Bean
 * @date: 2019/3/22 17:00
 */
public class Customer {
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String eMail;

    public Customer(String name, String sex, int age) {
        this(name,sex,age,"","");
    }

    public Customer(String name, String sex, int age, String phone, String eMail) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if ("male".equals(sex) || "female".equals(sex)){
            this.sex = sex;
        }else {
            System.out.println("性别有误");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age < 120){
            this.age = age;
        }else {
            System.out.println("年龄有误");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
