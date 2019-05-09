package Day19;

public class TicketTest {
    public static void main(String[] args) {
        TicketOffice ticket1 = new TicketOffice();
        TicketOffice ticket2 = new TicketOffice();
        TicketOffice ticket3 = new TicketOffice();

        ticket1.setName("窗口1");
        ticket2.setName("窗口2");
        ticket3.setName("窗口3");

        ticket1.start();
        ticket2.start();
        ticket3.start();

    }
}
