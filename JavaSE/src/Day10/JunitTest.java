package Day10;

import Day10.Polymorphism_1.Man;
import Day10.Polymorphism_1.Person;
import org.junit.Test;

/**
 * @cLassName: JunitTest
 * @author: cube
 * @description: TODO
 * @date: 2019/3/24 17:52
 */
public class JunitTest {
    @Test
    public void testMethod1(){
        Person person = new Man();
        person.say();
    }
}
