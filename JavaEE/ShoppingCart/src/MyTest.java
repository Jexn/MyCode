import Bean.Book;
import Dao.BookUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @program: MyTest
 * @description: Test
 * @author: Cube
 * @create: 2019-05-05 15:09
 **/
public class MyTest {
    @Test
    public void method1(){
        Map<Integer, Book> map = BookUtil.getAllBook();
        for (Map.Entry<Integer,Book> book: map.entrySet()){
            System.out.println(book);
        }

        System.out.println("-------------------");
        Book book = BookUtil.findBookById(2);
        System.out.println(book);
    }
}
