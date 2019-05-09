package Day08.experiment_2;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void withdraw(double value) {
        if (this.balance >= value) {
            this.balance -= value;
            System.out.println("取了：" + value + "元,剩余：" + this.balance + "元");
        } else {
            System.out.println("账户余额不足！余额：" + this.balance + "元");
        }
    }

    // 存钱
    public void deposit(double value) {
        if (value > 0) {
            this.balance += value;
            System.out.println("存了：" + value + "元,剩余：" + this.balance + "元");
        } else {
            System.out.println("参数错误");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
