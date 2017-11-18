package com.huawei.colin.NewFeatures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Java8NewFeatures {

    interface Convertor<F, T> {
        T convert(F from);
    }

    interface Add<F> {
        F add(F a, F b);
    }
    /**
     * Feature 1 : Lambda statement
     * @param str Test string
     * @return Return Value
     */
    public static Integer myLambda(String str) {


        // 1. Print a string converted into int
        Convertor<String, Integer> convertor = (from) -> Integer.valueOf(from);
        System.out.println(convertor.convert("123"));

        // 2. sort a list
        List<String> list = Arrays.asList("hu", "dongfeng", "feng");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        //Collections.sort(list, Comparator.naturalOrder());

        // 3. compute a + b
        Add<String> add = (a, b) -> (a + b);
        System.out.println(add.add("fjdksl", "jfldsjkl"));

        // 4. create a start
        new Thread(() -> System.out.println("Hudongfeng")).start();

        // 5. method reference
        List<String> list2 = Arrays.asList("hudognfeng", "123", "34324");
        list2.forEach(System.out::println);

        return convertor.convert("123");
    }
}
