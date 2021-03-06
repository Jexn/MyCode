package Day20;

/**
 * Java传递的值是变量的副本，如果是引用类型，传递的副本值是对应的地址值，如果是基本类型则是基本类型本身的值
 *
 * 在这个例子中，str，StringBuffer，person传递都是引用类型，都是地址值，相当于change方法里的代码共同管理实参
 *
 * 但str改变了地址指向，stringBuffer.append("yet change")和person.setAge(30)并没有改变指向
 *
 * 所以str只是让副本变化，和实参s断开联系，不在共同管理同一个地址上的值
 *
 * person = new Person("change",20);同时也是改变了副本的指向，所以形参和实参不再共同管理同一个对象
 */

public class ValueInterview {
    public static String change(String str,int i, StringBuffer stringBuffer,Person person){
        str = "change";
        i = 3;
        stringBuffer.append("yet change");
        person.setAge(30);
        person = new Person("change",20);
        return str;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Not");
        String s = "main";
        int i = 1;
        Person person = new Person("Not Change",50);
        i = 2;
        change(s,i,sb,person);

        System.out.println(s);
        System.out.println(sb);
        System.out.println(i);
        System.out.println(person);
    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

