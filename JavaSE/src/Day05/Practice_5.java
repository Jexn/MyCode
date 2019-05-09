package Day05;

public class Practice_5 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 2; i < 100000; i++){
            boolean isPrimer = true;
            for (int j = 2; j <= Math.sqrt(i);j++){
                if (i % j == 0){
                    isPrimer = false;
                    break;
                }
            }
            if (isPrimer){
                System.out.println(i);
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("time = " + time);
    }
}
