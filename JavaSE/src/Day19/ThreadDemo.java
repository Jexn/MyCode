package Day19;

import org.junit.Test;

public class ThreadDemo {

    // 多线程创建第一种方式
    @Test
    public void threadMethod1(){
        NumberThread thread1 = new NumberThread(1,100);
        thread1.start();

        NumberThread thread2 = new NumberThread(1000,10000);
        thread2.start();
    }

    // 匿名方式
    @Test
    public void threadMethod2(){
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 100;i++){
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
                System.out.println("Thread1 end");
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 100;i++){
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
                System.out.println("Thread2 end!");
            }
        };
        thread1.start();
        thread2.start();
    }
}
