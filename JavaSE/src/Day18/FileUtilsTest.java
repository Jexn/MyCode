package Day18;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {
    @Test
    public void fileUtilsTest(){
        File src = new File("File/CN.txt");
        File target = new File("File/FromFileUtils.txt");
        try {
            FileUtils.copyFile(src,target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
