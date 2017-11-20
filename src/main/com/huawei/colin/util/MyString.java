package com.huawei.colin.util;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;

import java.util.Date;

/**
 * @Author: hudongfeng
 * @Description: My String Utils
 * @Date: 2017/11/19
 */
public final class MyString {

    // Max string length we use
    private static final int MAX_LENGTH = 10000000;

    // How many loop we try
    private static final int TIMES = 10;

    /**
     * Compare the effect between StringBuilder、StringBuffer、String
     */
    public static void concatEffectCompare() {

        // string + effect
        long origin = new Date().getTime();
//        String str = "";
        int j = 0;
//        do {
//            for (int i = 0; i < MAX_LENGTH; i++) {
//                str += "x";
//            }
//        } while (++j < TIMES);
//
//        long plus_between = new Date().getTime() - origin;
//        System.out.println("String Plus Average : " + plus_between / TIMES + " ms ");

        // string builder effect
        origin = new Date().getTime();
        j = 0;
        StringBuilder sb = new StringBuilder();
        do {
            for (int i = 0; i < MAX_LENGTH; i++) {
                sb.append("x");
            }
        } while (++j < TIMES);
        long builder_between = new Date().getTime() - origin;
        System.out.println("String Builder Average : " + builder_between / TIMES + " ms ");

        // string buffer effect
        origin = new Date().getTime();
        j = 0;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            for (int i = 0; i < MAX_LENGTH; i++) {
                stringBuffer.append("x");
            }
        } while (++j < TIMES);
        long buffer_between = new Date().getTime() - origin;
        System.out.println("String Buffer Average : " + buffer_between / TIMES + " ms ");
    }

    /**
     * Check whether str is empty (null or length is 0)
     * @param str String
     * @return {@code true} if str is null or length equals 0, {@code false} otherwise
     */
    @NotNull
    @Contract(pure = true)
    public static boolean isEmpty(String str) {
        return str == null || str.length() < 1;
    }
}
