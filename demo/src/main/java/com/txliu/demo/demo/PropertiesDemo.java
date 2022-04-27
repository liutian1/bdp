package com.txliu.demo.demo;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 练习properties
 * @author txliu
 * @date 2022/4/26
 */
public class PropertiesDemo {

    public static void main(String[] args) {
        propertiesTest();
    }

    public static void propertiesTest() {
        Properties properties = new Properties();
        InputStream resourceAsStream = PropertiesDemo.class.getClassLoader().getResourceAsStream("log4j.properties");

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(properties, true));
    }
}
