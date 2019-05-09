package Day17;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {


    @Test
    public void randomReaderOrWriter(){
        try {
            RandomAccessFile randomAccessFile1 = new RandomAccessFile(new File("File/color.txt"),"r");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File("File/colorWriter.txt"),"rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFile1.read(bytes)) != -1){
                randomAccessFile2.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
