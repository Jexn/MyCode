package Day17;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    /**
     * FileReader和FileWrite适合用来读写文本文件：中文文本读取之类的
     * FileInputStream和FileOutputStream适用于读取非文本文件：视频、音乐、图片之类
     */
    @Test
    public void outputStream(){
        File file = new File("File/file2.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write("From FileOutputStream!".getBytes());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
