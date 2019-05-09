package Day19;

/**
 * 线程安全的懒汉式
 */
public class BankInstance {
    private static Bank bank = null;

    /**
     * 方式一，同步方法
     */
    public static synchronized Bank getInstance(){
        if (bank == null){
            bank = new Bank();
        }
        return bank;
    }

    /**
     * 方式二，同步代码块
     */

    public static Bank getBank(){
        if (bank == null){
            synchronized (Bank.class){
                if (bank == null){
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}

class Bank{
}