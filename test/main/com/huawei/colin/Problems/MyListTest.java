package com.huawei.colin.Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.function.Predicate.isEqual;
import static org.junit.Assert.*;

public class MyListTest {

    List<String> list = new ArrayList<String>();

    /**
     * init the environment
     */
    public void init() {
        String[] str = {"a", "b", "c", "d", "e"};
        for (String s:str) {
            list.add(s);
        }
    }

    @Test
    public void reverseList() throws Exception {
        init();
        new MyList<String>().reverseList(list);
        assertArrayEquals(list.toArray(), Arrays.asList("e", "d", "c", "b", "a").toArray());
    }

    @Test
    public void isPalindrome() throws Exception {
        assertFalse(MyList.isPalindrome("hudongfeng"));
        assertTrue(MyList.isPalindrome("123321"));
        assertTrue(MyList.isPalindrome("ORIIRO"));

    }
}