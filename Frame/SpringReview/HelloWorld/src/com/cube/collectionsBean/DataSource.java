package com.cube.collectionsBean;

import java.util.Properties;

/**
 * @author Cube
 * @className DataSource
 * @description
 * @date 2019-06-12 10:52
 */
public class DataSource {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
