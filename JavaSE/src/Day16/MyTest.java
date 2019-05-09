package Day16;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyTest {
    @Test
    public void genericsTest() {
        Map<String, Integer> map = new HashMap<>();

        map.put("老王", 78);
        map.put("老赵", 68);
        map.put("老钱", 88);
        map.put("老孙", 38);

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"===>"+entry.getValue());
        }
    }
}
