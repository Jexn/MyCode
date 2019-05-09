package Day14;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1203);

        updateList(list);
        System.out.println(list);

    }

    public static void updateList(List<Integer> list){

        /**
         * remove(Object obj)和remove(int index)
         * remove(Object obj)按值删除
         * remove(int index)按索引删除
          */

        list.remove(new Integer(2));
        list.remove(2);
    }
}
