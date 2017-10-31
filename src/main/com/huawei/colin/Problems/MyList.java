package com.huawei.colin.Problems;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MyList<T> {

    public static List<String> list = new ArrayList<String>();

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
}
