package Day21;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassReflectDemo {

    // 类的加载方式
    @Test
    public void method1(){
        // 方式一：运行时类的属性Class.class方式
        Class class1 = Person.class;

        // 方式二：运行时类对象的getClass()
        Person person = new Person("Tom",10);
        Class class2 = person.getClass();

        // 方式三：调用Class类的静态方法：forName(String className)
        try {
            Class class3 = Class.forName("Day21.Person");
            System.out.println(class1 == class2);
            System.out.println(class1 == class3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 方式四：使用类的加载器方式
        ClassLoader classLoader = ClassReflectDemo.class.getClassLoader();
        try {
            Class class4 = classLoader.loadClass("Day21.Person");
            System.out.println(class4);
            System.out.println(class1 == class4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 默认工程目录下文件加载
    @Test
    public void method2(){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("File/jdbc.properties");
            properties.load(fileInputStream);

            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name:"+name+",password:"+password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // src包目录下文件加载
    @Test
    public void method3(){
        Properties properties = new Properties();
        ClassLoader classLoader = ClassReflectDemo.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("Day21/jdbc.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name+":"+password);
    }

}
