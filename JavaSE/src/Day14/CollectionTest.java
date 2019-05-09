package Day14;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void arrayListTest() {
        Collection collection = new ArrayList();

        // 添加元素
        collection.add("AA");
        collection.add("MM");
        collection.add(123);

        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection = " + collection);

        // addAll
        Collection collection1 = new ArrayList();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);

        collection.addAll(collection1);
        System.out.println("collection1 = " + collection1);
        System.out.println("collection = " + collection);

        System.out.println("collection.isEmpty() = " + collection.isEmpty());
        collection.clear();
        System.out.println("collection.isEmpty() = " + collection.isEmpty());

    }

    @Test
    public void containsTest() {
        // 对于contains方法，其内部调用了equals方法，所以对于String来说只要内容相同既判断存在
        // 对于没有重写equals方法的对象则会判断为两个对象

        Collection collection = new ArrayList();
        Person person = new Person("Tom", 12);

        collection.add(new String("AA"));
        collection.add(person);
        System.out.println("collection.contains(new String(\"AA\")) = " + collection.contains(new String("AA")));
        System.out.println("collection.contains(new Person(\"Tom\",12)) = " + collection.contains(new Person("Tom", 12)));

        System.out.println("collection.contains(\"A\") = " + collection.contains("A"));

        Collection collection1 = new ArrayList();
        collection1.add(null);
        collection1.add("AA");
        System.out.println("collection1.size() = " + collection1.size());
        System.out.println("collection1 = " + collection1);
        System.out.println("collection.contains(null) = " + collection.contains(null));
    }

    @Test
    public void removeTest() {
        // 移除元素还是需要使用集合的contains方法的equals方法，所以对于对象而言需要实现equals方法

        Collection collection = new ArrayList();
        Person person = new Person("Tom", 12);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(person);

        System.out.println("collection = " + collection);

        collection.remove(1);

        System.out.println("remove 1 : collection = " + collection);

        collection.remove(new Person("Tom", 12));

        System.out.println("remove Person : collection = " + collection);

    }

    @Test
    public void iteratorTest() {
        Collection collection = new ArrayList();
        collection.add(11);
        collection.add(10);
        collection.add("ABC");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void syncList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list = Collections.synchronizedList(list);

        synchronized (list) {
            Iterator<Integer> iterator = list.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

    }
}
