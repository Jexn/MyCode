package Day08.experiment_2;

public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("帅德","布曜布曜德");

        bank.getCustomer(0).setAccount(new Account(10000));
        System.out.println(bank.getCustomer(0));
        bank.getCustomer(0).getAccount().withdraw(1024);
        bank.getCustomer(0).getAccount().deposit(2048);
        bank.getCustomer(0).getAccount().deposit(20480);
        bank.getCustomer(0).getAccount().withdraw(102400);
        System.out.println(bank.getCustomer(0));
    }
}
