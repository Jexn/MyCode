package Day19;

public class Deposit implements Runnable {
    private double money;

    public Deposit(double money) {
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            saveMoney();
        }
    }

    private synchronized void saveMoney() {
        money += 1000;
        System.out.println(Thread.currentThread().getName() + "存款：1000" + "，余额：" + this.money);
    }

    public double getMoney() {
        return money;
    }
}
