package com.txliu.demo.practice996;

import com.alibaba.fastjson.JSON;
import com.txliu.demo.cart.CartService;
import com.txliu.demo.cart.Sku;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author txliu
 * @date 2022/4/1811:39
 */
public class OptionalTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        getOdd(null);

        List<Sku> cartSkuList = CartService.getCartSkuList();
        Optional.ofNullable(cartSkuList)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(sku -> sku.getTotalPrice() > 200)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku,true)));


    }

    private static void getOdd(List<Integer> list) {
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(value -> value % 2 == 1)
                .forEach(System.out::println);


    }
}
