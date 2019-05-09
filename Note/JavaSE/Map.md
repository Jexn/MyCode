Map：存储的是双列数据：key-value
1. 所有的key构成的集合Set：无序、不可重复的
2. 所有的value构成的集合是Collection：无序、可重复的
3. 一个key-value构成一个Entry
4. 所有的Entry构成的集合都是Set：无序、不可重复的

HashSet的底层是使用HashMap进行存储的。
HashMap的所有的key构成集合就是HashSet。

* java.util.Map
    * HashMap：Map的主要实现类；线程不安全，效率高；可以存储null的key和value；（jdk8.0 数组+链表+红黑树）；
        * LinkedHashMap：HashMap的子类，对于频繁的遍历效率较高，可以按照添加的顺序遍历；（在HashMap的存储结构基础上，添加了一对双向链表）
    * TreeMap：可以按照key的指定的属性进行排序，底层实现：红黑树
    * Hashtable：Map的古老实现类；线程安全，效率低；不可以存储值为null的key
        * Properties：Hashtable的子类，常常用来处理属性文件；其key和value都是String类型；

## HashMap的底层实现
```Java
HashMap map = new HashMap();  
```

### jdk7.0情况
1. 底层创建了长度为16的Entry数组
2. 向HashMap中添加Entry1(key,value)，首先需要计算Entry1的key的Hash值（根据key所在类的hashCode()计算得到），此哈希值经过处理后，得到在底层Entry[]数组中要存储的位置i，如果位置i上没有元素，则Entry1直接添加成功;
3. 如果位置i上已经存在元素entry2(或还有链表存在的entry3,entry4)，则需要通过循环的方式，依次比较entry1中key和其他的entry的key是否相等。如果返回值为true，则使用entry1的value去替换equals为true的value。如果遍历之后，所有的equals都返回false，则entry1添加成功。则entry1指向原有的entry元素

默认情况下，如果添加元素的长度 >= 默认的长度 * 加载因子（临界值，默认是12，且新添加的数组位置不为null的情况，就默认扩容为原有长度的2倍。将原有的数据复制到新的数组中。） 

### jdk8.0（大体和jdk7.0类似）
1. 使用懒汉式加载，使用`new HashMap()`不会立即创建长度为16的数组，只有在首次使用put()后创建；
2. 当指定索引位置的链表长度大于8时，且整个map中的元素个数大于64时，此索引位置上的entry使用红黑树实现