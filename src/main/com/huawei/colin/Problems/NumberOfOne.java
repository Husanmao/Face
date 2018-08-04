package com.huawei.colin.Problems;

import org.jetbrains.annotations.Contract;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 10/07/2018
 */
public class NumberOfOne {

    public static void main(String[] args) {
        System.out.println(numberOfOneInBinary(-0x43921011));
    }

    public static int numberOfOneInBinary(int n) {
        int num = 0;
        while (n != 0) {
            if((n & 1) != 0)
                num++;
            n = n >>> 1;
        }
        return num;
    }
    
    @Contract(pure = true)
    public static int numberOfOneInBinary2(int n) {
        int num = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                num++;
            flag = flag << 1;
        }
        return num;
    }

    public static int numberOfOneInBinary3(int n) {
        int num = 0;
        while (n != 0) {
            n = n & (n - 1);
            num ++;
        }
        return num;
    }


}
