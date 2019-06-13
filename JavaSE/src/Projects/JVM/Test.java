package Projects.JVM;

/**
 * @author Cube
 * @className Test
 * @description
 * @date 2019-06-03 10:18
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        Object object = new Object();

        System.out.println("object.getClass().getClassLoader() = " + object.getClass().getClassLoader());
        System.out.println("user.getClass().getClassLoader() = " + user.getClass().getClassLoader());
        System.out.println("user.getClass().getClassLoader().getParent() = " + user.getClass().getClassLoader().getParent());
        System.out.println("user.getClass().getClassLoader().getParent().getParent() = " + user.getClass().getClassLoader().getParent().getParent());

        new Thread(() ->{

        },"you thread name").start();
    }
}
