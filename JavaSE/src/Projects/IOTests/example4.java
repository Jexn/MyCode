package Projects.IOTests;

import java.io.File;

public class example4 {

    public static void showFiles(File[] files) {
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                File[] innerFiles = files[i].listFiles();
                showFiles(innerFiles);
            }
            System.out.println(files[i].getName());
        }
    }

    public static void main(String[] args) {
        File file = new File("F:/MyCode/JavaSE");
        File[] files = file.listFiles();
        showFiles(files);
    }
}
