package Projects.IOTests;

import java.io.*;

public class example2 {
    public static void main(String[] args) {
        File file = new File("File/IO-Example/test.txt");

        try {
            FileReader inputStream = new FileReader(file);
            char[] chars = new char[10];
            int len;
            while ((len = inputStream.read(chars)) != -1){
                String temp = new String(chars,0,len);
                System.out.print(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
