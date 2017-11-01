package com.huawei.colin.Problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArithmeticTest {
    @Test
    public void phi() throws Exception {
        assertEquals(1, MyArithmetic.phi(1));
    }

    @Test
    public void biggestDivisor() throws Exception {
        assertEquals(13, MyArithmetic.biggestDivisor(13, 39));
    }

    @Test
    public void isPrime() throws Exception {
        long before = System.nanoTime();
        assertTrue(MyArithmetic.isPrime(19));
        for (int i = 1; i < 1000; i++) {
            MyArithmetic.isPrime(i);
        }
        long now = System.nanoTime();
        long cost = now - before;
        System.out.println("Counting all primes in 1~1000 cost "
                + cost / (1000.0 * 1000)
                + " ms");
    }

}