package com.huawei.colin.Problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArithmeticTest {
    @Test
    public void getGoldbach() throws Exception {
        assertArrayEquals(new int[]{5, 31}, MyArithmetic.getGoldbach(36));
    }

    @Test
    public void getGoldbachAtRange() throws Exception {
        int[] result = MyArithmetic.getGoldbachAtRange(2, 3000);
        assertArrayEquals(new int[]{992, 1382, 1856, 1928, 2078, 2438, 2512, 2530, 2618, 2642}, result);
    }

    @Test
    public void findPrimeFactors() throws Exception {
        MyArithmetic.findPrimeFactors(499);
    }

    @Test
    public void phi() throws Exception {
        assertEquals(42, MyArithmetic.phi(49));
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