package Projects.IOTests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class example1 {
    public static void main(String[] args) {
        File file = new File("File/IO-Example/test.txt");

        try {
            FileWriter fileWriter = new FileWriter(file,true);
            String str = "\"Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于 1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有 卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科 学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算和移动互 联网的产业环境下，Java更具备了显著优势和广阔前景。\"";
            fileWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
