package com.huawei.colin.Problems;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MyList<T> {

    public List<T> list = new ArrayList<T>();

    /**
     * Reverse a list
     * @param list
     */
    public void reverseList(@Nullable List<T> list) {
        Collections.reverse(list);
    }


    /**
     * Find out whether a list is a palindrome
     * @param str String to judge
     */
    @Contract(pure = true)
    public static boolean isPalindrome(@NotNull String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;
        for (int i = 0; i < len / 2; i++) {
            if (ch[i] != ch[len - i - 1]) return false;
        }
        return true;
    }

    /**
     * Find the K element of the list faest
     */
    public static int getKElement(@NotNull List<Integer> list, int k) {
        int value = 0;
        int len = list.size();
        if (len < k) return 0;
        List<Integer> list1 = list.subList(k, len);
        List<Integer> list2 = list;
        int i = 0;
        while (list1 != null) {
            i++;
            list1 = list.subList(k + i, len);
            list2 = list.subList(i, len);
        }

        return list2.get(0);
    }
}
