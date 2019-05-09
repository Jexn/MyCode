package Day18;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;

public class NIODemo {
    @Test
    public void pathTest(){
        Path path = Paths.get("File/CN.txt");

        System.out.println("path = " + path);
        System.out.println("path.startsWith(\"File\") = " + path.startsWith("File"));
        System.out.println("path.endsWith(\"CN.txt\") = " + path.endsWith("CN.txt"));
        System.out.println("path.isAbsolute() = " + path.isAbsolute());
        System.out.println("path.getParent() = " + path.getParent());
        System.out.println("path.getRoot() = " + path.getRoot());
        System.out.println("path.getFileName() = " + path.getFileName());
        System.out.println("path.getNameCount() = " + path.getNameCount());
        for (int i = 0; i < path.getNameCount();i++){
            System.out.println(path.getName(i));
        }
        System.out.println("path.toAbsolutePath() = " + path.toAbsolutePath());
    }

    // Files工具类的使用
    @Test
    public void filesTest(){
        Path path1 = Paths.get("File/CN.txt");
        Path path2 = Paths.get("File/PathsCopy.txt");

        try {
            Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.createDirectories(Paths.get("File/nio"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(Paths.get("File/nio"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.deleteIfExists(Paths.get("File/nio"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileMove(){
//        不能移动到不同磁盘
        Path path1 = Paths.get("d:","深入理解Android内核设计思想.pdf");
        Path path2 = Paths.get("File");

        try {
            Files.move(path1,path2,StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void channelTest() throws IOException {
        Path path = Paths.get("File","nio.txt");
        Files.createFile(path);
        Files.newByteChannel(path, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);
    }
}
