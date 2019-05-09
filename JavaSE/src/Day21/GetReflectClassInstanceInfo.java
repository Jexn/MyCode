package Day21;

import org.junit.Test;

import java.lang.reflect.*;

public class GetReflectClassInstanceInfo {

    // 创建运行时类的对象
    @Test
    public void method1() {
        try {
            Class getClass = Class.forName("Day21.Person");
            Person person = (Person) getClass.newInstance();
            System.out.println("person = " + person);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    // 获取运行时类声明为Public的构造器
    @Test
    public void getConstructor() throws ClassNotFoundException {
        Class myClass = Class.forName("Day21.Person");

        // 获取运行时类声明为Public的构造器
        System.out.println("获取运行时类声明为Public的构造器:");
        Constructor[] constructors = myClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("获取运行时类中所有的构造器:");
        // 获取运行时类中所有的构造器
        Constructor[] constructors1 = myClass.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }
    }

    // 获取类的属性信息
    @Test
    public void method2() {
        Class myClass = Person.class;

        System.out.println("获取公共属性：");
        Field[] fields = myClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("获取所有有属性：");
        Field[] fields1 = myClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
    }

    // 获取当前类属性详细情况
    @Test
    public void method3() {
        Class myClass = Person.class;

        Field[] fields = myClass.getDeclaredFields();

        for (Field field : fields) {
            // 1. 权限修饰符
            int modifier = field.getModifiers();
            System.out.print(Modifier.toString(modifier) + '\t');

            // 2. 类型
            Class type = field.getType();
            System.out.print(type.getName() + '\t');

            // 3. 变量名
            System.out.println(field.getName());
        }
    }

    // 获取运行类所声明的方法
    @Test
    public void method4() {
        try {
            Class myClass = Class.forName("Day21.Person");

            // 获取当前运行类及其父类中所声明的方法
            Method[] methods = myClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println("获取当前类所有方法：");
            // 获取当前运行类中声明的所有方法，不论权限大小
            Method[] methods1 = myClass.getDeclaredMethods();
            for (Method method : methods1) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取当前类的接口信息
    @Test
    public void method5() throws ClassNotFoundException {
        ClassLoader classLoader = GetReflectClassInstanceInfo.class.getClassLoader();
        Class myClass = classLoader.loadClass("Day21.Person");
        Class[] classes = myClass.getInterfaces();
        for (Class aClass : classes) {
            System.out.println(aClass);
        }
    }

    //获取运行时类的带泛型的父类的泛型
    //逻辑性代码     功能性代码
    @Test
    public void method6() {
        Class clazz = Person.class;
        Type genericSuperClass = clazz.getGenericSuperclass();
        ParameterizedType paramsType = (ParameterizedType) genericSuperClass;
        Type[] arguments = paramsType.getActualTypeArguments();
        System.out.println(((Class) arguments[0]).getName());
    }

    // 动态获取运行时类带泛型父类的泛型
    public String getGenericSuperClassParam(String className){
        try {
            Class targetClass = Class.forName(className);
            Type genericSuperClass = targetClass.getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
            Type[] arguments = parameterizedType.getActualTypeArguments();
            return ((Class) arguments[0]).getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void getGenericSuperClassParamTest(){
        String type = getGenericSuperClassParam("Day21.Person");
        System.out.println(type);
    }

    //获取运行时类的带泛型的父类
    @Test
    public void method7() {
        Class clazz = Person.class;

        Type genericSuperClass = clazz.getGenericSuperclass();
        System.out.println(genericSuperClass);
    }

    //获取运行时类的父类
    @Test
    public void method8() {
        Class clazz = Person.class;

        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        Class superClass1 = superClass.getSuperclass();
        System.out.println(superClass1);
    }

    //获取运行时类所属的包
    @Test
    public void method9() {
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }
}
