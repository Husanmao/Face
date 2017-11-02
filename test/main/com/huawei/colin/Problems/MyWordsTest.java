package com.huawei.colin.Problems;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class MyWordsTest {
    @Test
    public void spellOutWords() throws Exception {
        List<String> list = MyWords.spellOutWords("hu dong feng");
//        for(String str : list) {
//            System.out.println(str);
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void reverseStr() throws Exception {
        assertEquals("hudongfeng", MyWords.reverseStr("gnefgnoduh"));
    }

    @Test
    public void numOfAlphanumeric() throws Exception {
        int res = MyWords.numOfAlphanumeric("hu ???  dongfeng   :?\t ");
        assertEquals(10, res);
    }

    @Test
    public void numOfCharacter() throws Exception {
        assertEquals(2, MyWords.numOfCharacter('p'));
    }

    @Test
    public void getWordsNum() throws Exception {
        assertEquals(5, MyWords.getWordsNum("I like you very much!"));
    }

}