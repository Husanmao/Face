package com.huawei.colin.Problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayTest {
    @Test
    public void isPalindromic() throws Exception {
        assertTrue(MyArray.isPalindromic(new String[]{"hu", "dong", "feng", "feng", "dong", "hu"}));
    }

    @Test
    public void reverseStrArray() throws Exception {
        String[] test = {"hu", "dong", "feng"};
        Object[] res = MyArray.reverseStrArray(test);
        for (Object s:res) {
            System.out.println((String)s);
        }
    }

}