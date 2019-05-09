package Day17;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    /**
     * FileReader和FileWrite适合用来读写文本文件：中文文本读取之类的
     * FileInputStream和FileOutputStream适用于读取非文本文件：视频、音乐、图片之类
     */
    @Test
    public void fileInputStreamTest(){
        File file = new File("File/file1.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int content = fileInputStream.read();
            while (content != -1){
                System.out.print((char) content);
                content = fileInputStream.read();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void fileInputStreamReadArray(){
        File file = new File("File/file1.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer))!= -1){
                for (int i = 0; i < len; i++) {
                    System.out.print((char) buffer[i]);
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
