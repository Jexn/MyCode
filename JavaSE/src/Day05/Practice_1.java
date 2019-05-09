package Day05;

public class Practice_1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int flag = 5 - i;
            for (int j = 5; j >= flag;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            int flag = 5 - i;
            for (int j = 1; j < flag;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
