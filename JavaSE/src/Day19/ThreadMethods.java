package Day19;

import org.junit.Test;

public class ThreadMethods {

    // yield()方法释放当前CPU资源占用，但自身线程还可以继续抢占CPU资源
    @Test
    public void method1() {
        NumberThread thread1 = new NumberThread(1, 100);
        NumberThread thread2 = new NumberThread(101, 200);

        thread1.start();
        thread2.start();
    }

    // thread.join()阻塞当前线程，然后调用其他线程，等其他线程结束后再运行当前进程
    // 注意junit不支持多线程
    @Test
    public void method2(){
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 100;i++){
                    if ( i % 3 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 200;i++){
                    if (i % 5 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                    if (i % 30 == 0){
                        try {
                            thread1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        thread1.start();
        thread2.start();

        while (!thread2.isAlive()){
        }
        while (!thread1.isAlive()){
        }
    }

    /**
     *     设置线程优先级
     *     设置优先级后，对高优先级，使用优先调度的抢占式策略，抢占低优先级的执行，
     *     但是这并不意味高优先级的线程一定先于低优先级的的线程，而是从概率上讲，概率更高
      */
    @Test
    public void method3(){
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 100;i++){
                    if ( i % 3 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 200;i++){
                    if (i % 5 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        };

        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        while (!thread1.isAlive()){
        }
    }
}
