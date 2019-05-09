package Day17;

import org.junit.Test;

import java.io.*;

public class FileReaderTest {

    /**
     * FileReader和FileWrite适合用来读写文本文件：中文文本读取之类的
     * FileInputStream和FileOutputStream适用于读取非文本文件：视频、音乐、图片之类
     */
    @Test
    public void fileReader() {
        File file = new File("File/src.txt");

        try (FileReader reader = new FileReader(file)) {
            char[] chars = new char[30];
            int len;
            String temp = null;
            while ((len = reader.read(chars)) != -1) {
                temp = new String(chars, 0, len);
                System.out.println(temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void copy(String srcPath, String targetPath) {
        File src = new File(srcPath);
        File target = new File(targetPath);

        try (FileReader reader = new FileReader(src);
             FileWriter writer = new FileWriter(target, true);
        ) {
            char[] chars = new char[16];
            int len;
            String temp = null;
            while ((len = reader.read(chars))!= -1){
                temp = new String(chars,0,len);
                writer.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyTest(){
        copy("File/CN.txt","File/CN-Copy.txt");
    }
}
