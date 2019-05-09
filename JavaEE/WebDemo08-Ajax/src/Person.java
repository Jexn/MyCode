public class Person {
    private String name;
    private String privilege;

    public Person(String name, String privilege) {
        this.name = name;
        this.privilege = privilege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
