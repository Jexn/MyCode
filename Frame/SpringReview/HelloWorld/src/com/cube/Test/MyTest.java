package com.cube.Test;

import com.cube.beans.Car;
import com.cube.beans.Person;
import com.cube.collectionsBean.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-06-12 09:58
 */
public class MyTest {

    @Test
    public void constructorTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }

    @Test
    public void referenceTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        //外部bean
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println(person1);
    }

    @Test
    public void collectionsBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        com.cube.collectionsBean.Person SC = (com.cube.collectionsBean.Person) applicationContext.getBean("collectionPerson");
        System.out.println(SC);
    }

    @Test
    public void DataSourceTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void autowireTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-autowire.xml");
        com.cube.autowire.Person person = (com.cube.autowire.Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void scopeSingleton(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-scope.xml");
        com.cube.autowire.Car car0 = (com.cube.autowire.Car) applicationContext.getBean("car");
        com.cube.autowire.Car car1 = (com.cube.autowire.Car) applicationContext.getBean("car");
        System.out.println(car0 == car1);
    }

    @Test
    public void scopePrototype(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-scope.xml");
        com.cube.autowire.Car car0 = (com.cube.autowire.Car) applicationContext.getBean("car2");
        com.cube.autowire.Car car1 = (com.cube.autowire.Car) applicationContext.getBean("car2");
        System.out.println(car0 == car1);
    }
}
