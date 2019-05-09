package Day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        File src = new File("File/src.txt");
        File target = new File("File/target.txt");

        if (!target.exists()){
            try {
                target.createNewFile();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

        try (
                FileInputStream fileInputStream = new FileInputStream(src);
                FileOutputStream fileOutputStream = new FileOutputStream(target,true);
        ) {
            byte[] bytes = new byte[10];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
