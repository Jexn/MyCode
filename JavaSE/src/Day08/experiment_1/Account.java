package Day08.experiment_1;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // 取钱
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("取了：" + amount + "元,剩余：" + this.balance + "元");
        } else {
            System.out.println("账户余额不足！余额：" + this.balance + "元");
        }
    }

    // 存钱
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("存了：" + amount + "元,剩余：" + this.balance + "元");
        } else {
            System.out.println("参数错误");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate * 100 + "%" +
                '}';
    }
}
