package com.cube.Factory;

import com.cube.bean.Person;

/**
 * @author Cube
 * @className PersonFactory
 * @description
 * @date 2019-06-12 17:27
 */
public class PersonFactory {
    private static Person person = null;

    public Person getInstance() {
        if (person == null) {
            person = new Person(9999, "工厂类");
        }
        return person;
    }

    public static Person getInStance(){
        if (person == null) {
            person = new Person(9999, "工厂类");
        }
        return person;
    }
}
