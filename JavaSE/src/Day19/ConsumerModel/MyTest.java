package Day19.ConsumerModel;

public class MyTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);
        Consumer consumer1 = new Consumer(clerk);

        consumer.setName("消费者");
        consumer1.setName("消费者1");
        producer.setName("生产者");

        producer.start();
        consumer.start();
        consumer1.start();
    }
}
