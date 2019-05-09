package Day11;

/**
 * @cLassName: SingletonModel_1
 * @author: cube
 * @description: 单例模式（饿汉式，不存在线程安全问题）
 * @date: 2019/3/25 14:57
 */
public class SingletonModel_1 {
    /*
    1.私有化构造器
    2.内部提供一个静态的当前类实例
    3.提供一个获取当前类实例的静态方法
     */
    private static SingletonModel_1 singletonModel = new SingletonModel_1();

    private SingletonModel_1(){
    }

    public static SingletonModel_1 getInstance(){
        return singletonModel;
    }
}
