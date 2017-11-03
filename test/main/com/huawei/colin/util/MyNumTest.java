package com.huawei.colin.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyNumTest {
    @Test
    public void getRandom() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println(MyNum.getRandom());
        }
    }

}