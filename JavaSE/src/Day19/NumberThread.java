package Day19;

public class NumberThread extends Thread{
    private int start;
    private int end;

    public NumberThread(int start,int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            // 此时通过yield()方法可以临时释放CPU资源占用，CPU资源可以给其他进程占用
            if (i % 20 == 0){
                yield();
            }
        }
    }
}
