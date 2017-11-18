package com.huawei.colin.util;

import com.sun.istack.internal.NotNull;

/**
 * @Author: hudongfeng
 * @Description: For Java Ascii encoding or decoding
 * @Date: 2017/11/18
 */
public final class MyASCII {


    private static final String FILTER = ",";

    /**
     * Test all method
     */
    public static void printAll() {
        for (int i = 0; i <= 127; i++) {
            System.out.println(i + " <--> " + intToCharAscii(i) + " ");
        }

        String temp;
        System.out.println(temp = stringToAscii("胡东风"));
        System.out.println(asciiToString(temp));
    }

    /**
     * Translate int to char, by hard encoding
     * @param i The int
     * @return Translated char
     */
    public static char intToCharAscii(final int i) {
        return (char)i;
    }

    /**
     * translate char to int, by hard encoding
     * @param c The char
     * @return Translated char
     */
    public static int charToIntAscii(final char c) {
        return (int)c;
    }

    /**
     * Translate string to int string (int split with {@link #FILTER})
     * @param s The string to encode
     * @return Encoded int string
     */
    @NotNull
    public static String stringToAscii(@NotNull String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            sb.append((int)c).append(FILTER);
        }
        int len = sb.length();
        return sb.substring(0, len > 0 ? len - 1 : 0);
    }

    /**
     * Translate ascii code (int split with ",") to string
     * @param s The int string (eg:"234,532") to decode
     * @return Decoded string
     */
    @NotNull
    public static String asciiToString(@NotNull String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(FILTER);
        for (String str : ss) {
            sb.append((char)Integer.parseInt(str));
        }
        return sb.toString();
    }
}
