package com.huawei.colin.Problems;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MyArithmetic {

    /**
     * Determine whether a given integer number is prime
     * @param num Num to judge if prime
     * @return @{true} if num is prime, @{false} otherwhise
     */
    public static boolean isPrime(int num) {

        if (num < 1) return false;  // 0 or negative isn't prime
        for (int i = 2; i * i <= num; i++) {
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

    /**
     * Write a method that prints the prime factors of a given positive integer
     * @param num The given positive num
     */
    public static void findPrimeFactors(int num) {
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                System.out.println(i + " ");
                num /= i;
            }
        }
        if (num > 1) System.out.println(num + " ");
        else System.out.println("");
    }


    /**
     *  Write a predicate to find the two prime numbers that sum up to a given even number.
     *  @param num
     */
    @Contract(pure = true)
    public static int[] getGoldbach(int num) {
        int[] result = new int[2];
        if (num % 2 != 0)
            throw new IllegalArgumentException();

        for (int i = 2; 2 * i <= num; i++) {
            if (isPrime(i) && isPrime(num - i)) {
                result[0] = i;
                result[1] = num - i;
                break;
            }
        }
        return result;
    }
    /**
     * Given a range of integers by its lower and upper limit,
     * print a list of all even numbers and their Goldbach composition.
     * @param low The minium even number
     * @param high The maxium even number
     * @return Array contains of suitable even number
     */
    @NotNull
    @Contract(pure = true)
    public static int[] getGoldbachAtRange(int low, int high) {
        int[] result = new int[2000];
        int j = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 0) {
                int[] temp = getGoldbach(i);
                if (temp[0] > 50 && temp[1] > 50) {
                    result[j++] = i;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, j);
    }
}
