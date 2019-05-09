package Day19.ConsumerModel;

public class Clerk extends Thread {
    private int productNum = 0;

    // 生产产品
    public synchronized void produceProduct() {
        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productNum + "产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费产品
    public synchronized void consumerProduct() {
        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productNum + "产品");
            productNum--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
