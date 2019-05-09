package Projects.IOTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class example3 {
    public static void main(String[] args) {
        File src = new File("File/IO-Example/test.txt");
        File target = new File("File/IO-Example/test2.txt");

        try (
                FileInputStream fileInputStream = new FileInputStream(src);
                FileOutputStream fileOutputStream = new FileOutputStream(target)) {
            byte[] bytes = new byte[30];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
