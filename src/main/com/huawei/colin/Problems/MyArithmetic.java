package com.huawei.colin.Problems;

import org.jetbrains.annotations.Contract;

public class MyArithmetic {

    /**
     * Determine whether a given integer number is prime
     * @param num Num to judge if prime
     * @return @{true} if num is prime, @{false} otherwhise
     */
    public static boolean isPrime(int num) {

        if (num < 1) return false;  // 0 or negative isn't prime
        int range = (int)(Math.log(num) / Math.log(2));
        for (int i = 2; i <= range; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Greatest Common Divisor of two positive integer numbers
     *  a / biggest b / biggest = a%b / biggest
     * @param small First num
     * @param big Second num
     * @return The biggest common divisor of two positive integer numbers
     */
    @Contract(pure = true)
    public static int biggestDivisor(int small, int big) {

        if (small < 1 || big < 1)
            throw new IllegalArgumentException();

        if (small > big) {
            small = small + big;
            big = small - big;
            small = small - big;
        }

        while (small > 0) {
            int reminder = big % small;
            big = small;
            small = reminder;
        }
        return big;
    }

    /**
     * If two values are coprime
     * @param a a
     * @param b b
     * @return If two values are coprime
     */
    @Contract(pure = true)
    public static boolean isCoprime(int a, int b) {
        return biggestDivisor(a, b) == 1 ? true : false;
    }

    /**
     * The number of positive integers r (1 <= r < m) that are coprime to m
     * @param m The range
     * @return the number of positive integers
     */
    @Contract(pure = true)
    public static int phi(int m) {
        int num = 0;
        if (m == 1) return 1;
        for (int i = 1; i < m; i++) {
            if (isCoprime(i, m)) num++;
        }
        return num;
    }
}
