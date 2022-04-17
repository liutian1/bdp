package com.txliu.demo.cart;

import java.util.List;
import java.util.OptionalDouble;

/**
 * @ClassName : PracitceSteam
 * @Author : txliu
 * @Date: 2022-04-16 20:23
 */
public class PracitceSteam {
    public static void main(String[] args) {
        List<Sku> cartSkuList = CartService.getCartSkuList();
//        Map<Boolean, List<Sku>> collect = cartSkuList.stream().collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 1000));
//        System.out.println(JSON.toJSONString(collect,true));
        OptionalDouble max = cartSkuList.stream()
                .map(Sku::getTotalPrice)
                .mapToDouble(Double::doubleValue)
                .max();
        System.out.println(max.getAsDouble());

    }
}
