package com.txliu.demo.practice996;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName : Person
 * @Author : txliu
 * @Date: 2022-04-20 21:15
 */
@AllArgsConstructor
@Data
public class Person {
    private String name;
    private Integer age;

    public Person() {

    }
}
