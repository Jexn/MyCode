package Day08.experiment_1;

public class UserTest {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Jane", "Smith");
        customer1.setAccount(new Account(1000,2000,0.0123));

        customer1.getAccount().deposit(100);
        customer1.getAccount().withdraw(960);
        customer1.getAccount().withdraw(2000);

        System.out.println(customer1);

    }
}
