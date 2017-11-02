package com.huawei.colin.Problems;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyWords {

    private static final String STR = "I do appreciate it!";
    /**
     * Get the number of words in a sentence
     * @param sentence The sentence
     * @return Number of words
     */
    @Contract(pure = true)
    public static int getWordsNum(@NotNull String sentence) {
        return sentence.split("\\s+").length;
    }

    /**
     * Get the number of characters in a sentence
     * @param character The char to count
     * @return Times the character appears
     */
    @Contract(pure = true)
    public static int numOfCharacter(@NotNull char character) {
        int times = 0;
//        for(char c : STR.toCharArray()) {
//            if (c == character) times++;
//        }
        for (int i = 0; i < STR.length(); i++) {
//            if (STR.charAt(i) == character) times++;
//            if (STR.substring(i, i + 1).equals(character + "")) times++;
            if (STR.substring(i, i + 1).matches(character + "")) times++;
        }
        return times;
    }

    /**
     * Get the number of alphanumeric in a sentence
     * @param sentence The sentence to count
     * @return The number of alphanumeric in a sentence
     */
    @Contract(pure = true)
    public static int numOfAlphanumeric(@NotNull String sentence) {
        String filted = sentence.replaceAll("[^0-9A-Za-z]", "");
        return filted.length();
    }

    /**
     * Reverse the string
     * @param str The string to reverse
     * @return The reversed string
     */
    @NotNull
    @Contract(pure = true)
    public static String reverseStr(@NotNull String str) {
//        char[] chs = str.toCharArray();
//        char[] res = new char[chs.length];
//        for (int i = 0; i < chs.length; i++) {
//            res[i] = chs[chs.length - i - 1];
//        }
//        return String.copyValueOf(res);
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * If a string is Palindromes
     * @param str The string to check
     * @return true if string is Palindromes, false otherwise
     */
    public static boolean isPalindromes(@NotNull String str) {
        if (str.equals(reverseStr(str))) return true;
        return false;
    }

    /**
     * Spell out words
     * @param sentence The sentence to spell out
     * @return List contails all words in x-x-x-x
     */
    public static List<String> spellOutWords(@NotNull  String sentence) {
        List<String> list = new LinkedList<String>();

        String[] strs = sentence.split("[^A-Za-z]+");
        if (strs == null)
            throw new IllegalArgumentException();

        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            char[] temp = str.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                if (i != temp.length - 1) {
                    sb.append(temp[i]).append("-");
                } else {
                    sb.append(temp[i]);
                }
            }
            list.add(sb.toString().toUpperCase());
        }
        return list;
    }
}
