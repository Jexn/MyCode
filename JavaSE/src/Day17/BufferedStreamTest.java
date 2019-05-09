package Day17;

import org.junit.Test;

import java.io.*;

public class BufferedStreamTest {
    @Test
    public void bufferedInputStream() throws InterruptedException {
        File src = new File("E:\\视频\\300MIUM-120.mp4");
        File target1 = new File("F:\\cute1.mp4");
        File target2 = new File("F:\\cute2.mp4");
        byteCopy(src, target1);         //byteCopy耗时：47728
        bufferedCopy(src, target2);         //bufferedCopy：耗时6855
    }

    @Test
    public void bufferedWriteAndReader() {
        File src = new File("File/CN.txt");
        File target = new File("File/bufferedWriteCopy.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(src));
                BufferedWriter writer = new BufferedWriter(new FileWriter(target));
        ) {
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void byteCopy(File src, File target) {
        try (FileInputStream inputStream = new FileInputStream(src);
             FileOutputStream outputStream = new FileOutputStream(target)) {

            long start = System.currentTimeMillis();

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("byteCopy耗时：" + (end - start));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void bufferedCopy(File src, File target) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(target));
        ) {
            long start = System.currentTimeMillis();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("bufferedCopy耗时：" + (end - start));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
