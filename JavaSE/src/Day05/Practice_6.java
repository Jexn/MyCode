package Day05;

public class Practice_6 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            int value = 0;
            for (int j = 1; j < i; j++){
                if (i % j == 0){
                    value += j;
                }
            }
            if (i == value){
                System.out.println(i);
            }
        }
    }
}
