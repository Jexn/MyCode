package Day19;

public class DepositTest {
    public static void main(String[] args) {
        Deposit deposit = new Deposit(3000);

        Thread thread1 = new Thread(deposit);
        Thread thread2 = new Thread(deposit);

        thread1.setName("用户1");
        thread2.setName("用户2");

        thread1.start();
        thread2.start();

        while (thread1.isAlive()){
        }

        while (thread2.isAlive()){
        }

        System.out.println(deposit.getMoney());
    }
}
