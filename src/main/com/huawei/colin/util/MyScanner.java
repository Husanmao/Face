package com.huawei.colin.util;

import java.util.Scanner;

/**
 * @Author: hudongfeng
 * @Description: 获取用户输入
 * @Date: 01/07/2018
 */
public class MyScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String rules = sc.next();
            System.out.println(rules);
        }
    }
}
