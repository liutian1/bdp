package com.txliu.demo.practice996;

import com.alibaba.fastjson.JSON;
import com.txliu.demo.demo.PropertiesDemo;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName : PersonTest
 * @Author : txliu
 * @Date: 2022-04-20 21:16
 */
public class PersonTest {
    public static final Logger logger = Logger.getLogger(PersonTest.class);
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("123523625");
        Map<String, String> map = new HashMap<>();
        map.put("zhangsan","男");
        System.out.println(JSON.toJSONString(map, true));
        logger.info("123456");
        PropertiesDemo.propertiesTest();
        System.out.println("conf");
    }
}
