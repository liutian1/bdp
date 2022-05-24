package com.txliu.demo.practice996;

import com.alibaba.fastjson.JSON;
import com.txliu.demo.demo.PropertiesDemo;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName : PersonTest
 * @Author : txliu
 * @Date: 2022-04-20 21:16
 */
public class PersonTest {
    public static final Logger logger = Logger.getLogger(PersonTest.class);
    public static void main(String[] args) throws IOException {
        System.out.println("************assembly**************");
        Person person = new Person();
        System.out.println("123523625");
        Map<String, String> map = new HashMap<>();
        map.put("zhangsan","男");
        System.out.println(JSON.toJSONString(map, true));
        logger.info("123456");
        PropertiesDemo.propertiesTest();
        System.out.println("conf");
        InputStream resourceAsStream = PersonTest.class.getClassLoader().getResourceAsStream("test.txt");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("conf/test.properties")));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line = null;
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
