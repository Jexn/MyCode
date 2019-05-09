package Day11;

/**
 * @cLassName: SingletonModel_2
 * @author: cube
 * @description: 单列模式（懒汉式，存在线程安全问题）
 * @date: 2019/3/25 15:14
 */
public class SingletonModel_2 {
    private static SingletonModel_2 singletonModel = null;

    private SingletonModel_2() {

    }

    public static SingletonModel_2 getInstance() {
        if (singletonModel == null) {
            singletonModel = new SingletonModel_2();
        }
        return singletonModel;
    }
}
