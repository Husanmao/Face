package com.huawei.colin.Problems;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 10/07/2018
 */
public class NumberOfOneTest {

    int num = 0;
    int a = new Random().nextInt();

    @Before
    public void setUp() throws Exception {

        char[] str = Integer.toBinaryString(a).toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '1') {
                num++;
            }
        }
    }

    @Test
    public void numberOfOneInBinary() throws Exception {
        assertEquals(num, NumberOfOne.numberOfOneInBinary(a));
    }

    @Test
    public void numberOfOneInBinary2() throws Exception {
        assertEquals(num, NumberOfOne.numberOfOneInBinary2(a));
    }

    @Test
    public void numberOfOneInBinary3() throws Exception {
        assertEquals(num, NumberOfOne.numberOfOneInBinary3(a));
    }

}