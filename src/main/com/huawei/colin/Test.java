package com.huawei.colin;

import com.huawei.colin.util.LoggerUtil;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Test class
 */
public class Test {

    /** logger */
    private static final Logger LOGGER = Logger.getLogger(Test.class);

    /** Tag */
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

        /* test java 8 lambda */
//        System.out.println(acronym("jklfjds kldfj K fd"));
//        Java8NewFeatures.myLambda("hudongfeng");
//        System.out.println(TAG);

        /* compare kinds of method concat efficient */
        //MyString.concatEffectCompare();

        /* java foreach loop */
//        Map<String, String> map = DP.initMap();
//        map.forEach((k, x)-> System.out.println(k + " -> " + x));

        /* compare kinds of method efficient */
//        MyLoop.loopEffect();
        /* compare Arrays.copyOfRange and System.arraycopy efficient */
//        MyArray.copyArrays();

        /* test if Array.copyOfRange copy value or copy ref */
//        String[] str1 = {"hu", "dongfeng", "feng"};
//        String[] str2 = Arrays.copyOfRange(str1, 0, 3);

        LoggerUtil.debug(LOGGER, " " + "args = [" + args + "]");
    }
}