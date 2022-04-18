package com.txliu.demo.cart;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author txliu
 * @date 2022/4/1816:04
 */
public class StreamOpt {
    public static void main(String[] args) {
        List<Sku> cartSkuList = CartService.getCartSkuList();
//        System.out.println(filterDemo(null));

        mapOpt(cartSkuList);
    }

    private static void mapOpt(List<Sku> cartSkuList) {
        Map<Boolean, List<Sku>> collect1 = Optional.ofNullable(cartSkuList)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .sorted(Comparator.comparing(Sku::getTotalPrice, Comparator.reverseOrder()))
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));


        System.out.println(JSON.toJSONString(collect1,true));

    }

//    public static Long filterDemo(List<Sku> cartSkuList) {
//      return   Optional.ofNullable(cartSkuList)
//                .map(List::stream)
//                .orElseGet(Stream::empty)
//                .filter(sku -> sku.getTotalPrice() > 200)
//                .count();
//    }

}
