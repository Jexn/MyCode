package Day19;

public class TicketOffice extends Thread {
    public static int ticketNumber = 1000;

    @Override
    public void run() {
        while (ticketNumber > 0) {
            int num = (int) (Math.random() * 5 + 1);
            ticketNumber -= num;
            System.out.println(Thread.currentThread().getName() + "售出：" + num+"张票，剩余："+ticketNumber);
        }
        System.out.println("没有票了！");
    }
}
