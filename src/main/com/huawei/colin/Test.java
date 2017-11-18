package com.huawei.colin;

import com.huawei.colin.NewFeatures.Java8NewFeatures;
import com.huawei.colin.util.MyString;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Test class
 */
public class Test {

    public static final String TAG = Test.class.getSimpleName();

    private static final List<String> STOP_WORDS = Arrays.asList("AND", "OR", "BY", "OF");

    interface Convertor<F, T> {
        T convert(F from);
    }

    /**
     * @param input
     * @return
     */
    public static String acronym(final String input) {
        return Arrays
                .stream(input.toUpperCase().split("\\s"))
                .filter(word -> !STOP_WORDS.contains(word))
                .map(w -> String.valueOf(w.charAt(0)))
                .collect(joining(","));
    }

    public static void main(String[] args) {
        System.out.println(acronym("jklfjds kldfj K fd"));
        Java8NewFeatures.myLambda("hudongfeng");
        System.out.println(TAG);
        MyString.concatEffectCompare();
    }
}