package Day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new TicketOffice());
        service.execute(new TicketOffice());

        service.shutdown();

    }
}
