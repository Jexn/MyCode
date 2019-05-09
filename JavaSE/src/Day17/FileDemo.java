package Day17;

import Projects.TeamProject.Service.Data;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class FileDemo {
    @Test
    public void fileTest(){
        File file = new File("File/file1.txt");

        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());
        System.out.println("file.getPath() = " + file.getPath());

        File file2 = new File(file.getParent(),"file2.txt");
        try {
            boolean check = file2.createNewFile();
            File file3 = new File(file2.getParent(),"text.txt");
            Boolean flag = file2.renameTo(file3);
            System.out.println("flag = " + flag);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void fileInfo(){
        File file = new File("File/file1.txt");

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.canRead() = " + file.canRead());
        System.out.println("file.canWrite() = " + file.canWrite());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(file.lastModified()));
        System.out.println("file.lastModified() = " + calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)
                +" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE));
        System.out.println("file.length() = " + file.length());
    }

    @Test
    public void fileList(){
        File file = new File("D:\\Java视频\\尚硅谷Java大数据\\阶段1：java基础\\视频+代码\\day22");

        File[] files = file.listFiles();
        listFile(files);
    }

    public void listFile(File[] files){
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() && files[i] != null){
                File[] fileInner = files[i].listFiles();
                listFile(fileInner);
            }
            System.out.println(files[i]);
        }
    }
}
