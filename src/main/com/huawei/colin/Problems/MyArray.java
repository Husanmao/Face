package com.huawei.colin.Problems;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyArray {


    public static void main(String[] args) {
        findMidSortedArray(new int[]{3, 32, 532, 1432, 234324325, 1321412532}, new int[]{334, 3453, 234325, 43578943});
    }

    /**
     * reverse a string array
     * @param str The string array
     * @return Reversed string array
     */
    @NotNull
    @Contract(pure = true)
    public static Object[] reverseStrArray(@NotNull String[] str) {
        List<String> list = new ArrayList<String>();
        for(String s:str) {
            list.add(s);
        }
        Collections.reverse(list);
        return list.toArray();
    }

    /**
     * Check if the array is a Palindromic array
     * @param str The array
     * @return {@code true} if it's a palindromic array
     *         {@code false} otherwise
     */
    public static boolean isPalindromic(@NotNull String[] str) {
        Object[] reverse = reverseStrArray(str);
        int len = str.length;

        for (int i = 0; i < len; i++) {
            if (!str[i].equals((String)reverse[i])) return false;
        }
        return true;
    }

    /**
     * Find Median of Two Sorted Arrays in O(log(m + n))
     * @param m First array
     * @param n Second array
     * @return The median of m and n
     */
    public static int findMidSortedArray(int[] m, int[] n) {
        int[] all = new int[m.length + n.length];
        int i, j, k = 0;
        for (i = 0, j = 0; i < m.length && j < n.length;) {
            System.out.println(" i = " + i + " and j = " + j);
            if (m[i] <= n[j]) {
                all[k] = m[i];
                i++;
            } else {
                all[k] = n[j];
                j++;
            }
            k++;
        }

        while (i < m.length) {
            all[k++] = m[i++];
        }

        while (j < n.length) {
            all[k++] = n[j++];
        }

        for (int s:all) {
            System.out.print(" " + s);
        }
        return 0;
    }
}
