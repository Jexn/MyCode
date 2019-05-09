package Day04;

public class NarcissusNum {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = i % 100 / 10;
            int c = i % 10;

            double value = Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3);
            if (i == value){
                System.out.println(i);
            }
        }
    }
}
