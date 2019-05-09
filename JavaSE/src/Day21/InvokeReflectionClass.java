package Day21;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 使用反射，调用运行时类中指定的结构：属性、方法、构造器（掌握）
public class InvokeReflectionClass {

    // 获取public指定属性
    @Test
    public void method1() throws Exception {
        Class myClass = Person.class;
        // 获取运行时类属性，getField只能获取public权限的属性
        Field field = myClass.getField("age");
        System.out.println(field);

        // 设置运行时类属性
        Person person = (Person) myClass.newInstance();
        field.set(person, 20);
        int age = (int) field.get(person);
        System.out.println(age);
    }

    // 获取所有权限的属性
    @Test
    public void method2() throws Exception {
        Class myClass = Person.class;

        Field field = myClass.getDeclaredField("name");
        System.out.println(field);
        Person person = (Person) myClass.newInstance();

        // 保证当前属性可设置
        field.setAccessible(true);
        field.set(person, "Tom");

        String name = (String) field.get(person);
        System.out.println(name);

    }

    // 获取运行时类指定的方法
    @Test
    public void method3() throws Exception {
        Class myClass = Person.class;

        // getDeclaredMethod(String methodName,Class...params)：获取当前类指定的方法
        Method method = myClass.getDeclaredMethod("setLocal", String.class);

        // 保证方法可访问
        method.setAccessible(true);
        Person person = (Person) myClass.newInstance();
        method.invoke(person, "广东广州");

    }

    // 调用构造器
    @Test
    public void method4() throws Exception {
        Class myClass = Person.class;
        Constructor constructor = myClass.getDeclaredConstructor(String.class, int.class);

        // 设置构造器可设置
        constructor.setAccessible(true);
        Person person = (Person) constructor.newInstance("Jack",20);
        System.out.println(person);
    }
}
