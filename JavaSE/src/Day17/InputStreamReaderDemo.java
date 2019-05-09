package Day17;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputStreamReaderDemo {

    @Test
    public void inputStreamReader() {
        File file = new File("File/CN.txt");
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"utf-8")) {
            char[] chars = new char[10];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1){
                String string = new String(chars,0,len);
                System.out.println(string);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void standerIO(){
        Scanner in = new Scanner(System.in);
        System.out.println("输入e或exit退出:");
        String input = in.nextLine();
        System.out.println(input);
//        for (;;){
//            input = input.toLowerCase();
//            if ("e".equals(input) || "exit".equals(input)){
//                break;
//            }
//            input = in.next();
//        }
    }
}
