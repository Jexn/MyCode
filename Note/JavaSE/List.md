## 两个remove方法
[参考代码](..\..\JavaSE\src\Day14\Example.java)

## ArrayList、LinkedList和Vertor区别

ArrayList、LinkedList、Vertor都是List接口的实现类，存储的数据都是有序的、可重复的。

* java.lang.Collection：单列数据
    * List子接口：存储有序、可重复的的数据 --->“动态”数组
        * ArrayList：作为List的主要实现类，线程不安全，效率高；（Collections中定义了`Collections.synchronizedList(list)`方法可以得到一个线程安全的List)；*底层使用数组实现*
        * LinkedList：对于频繁的删除、插入操作，建议使用LinkedList；*底层采用了双向链表存储*
        * Vector：List的古老实现类；线程安全，效率低；*底层使用数组实现*
    * Set子接口：存储有序、不可重复的数据
        * HashSet：是Set的主要实现类。底层使用了数组+链表，HashMap实现。往一个HashSet表中添加一个数据，先调用hashCode()方法计算其hashCode值，然后查看其对应的存储位置是否存在元素，如果是空的，添加成功。如果对应的存储位置有元素，则再次调用equals()方法，验证两个元素是否相等，如果不相等则采用链式结构添加到这个元素之后。如果相等，添加失败。
            * LinkedHashSet：是HashSet的子类，在HashSet底层的基础上添加了两个指针，能够记住下一个上一个的元素对象。
        * TreeSet：可以按照添加的元素的指定属性的小心进行遍历。底层实现：红黑树。TreeSet添加自定义元素的时候需要实现comparable接口（自然排序）或者使用定制排序重写comparator（定制排序）；（[参考代码](..\..\JavaSE\src\Day15\SetTest.java)）

## comparable和comparator接口
[参考代码](..\..\JavaSE\src\Day15\Practice\Employee.java)

## HashSet笔试题

[代码](..\..\JavaSE\src\Day16\Practice\Test.java)
