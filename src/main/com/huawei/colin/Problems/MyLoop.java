package com.huawei.colin.Problems;

import java.util.*;

public class MyLoop {

    // list we store numbers
    private static List<String> list = new ArrayList<String>();

    // how many times we loop
    private static final int MAX_NUM = 100000000;

    // how many loop we try
    private static final int MAX_TIMES = 100;
    /**
     * check if user has input yes.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String resp = "";
        do {
            System.out.println("Are we there yet?");
        } while (!scanner.nextLine().equals("yes"));
        System.out.println("Well done");

        triangle();
        tableSquare();
    }

    public static void triangle() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void tableSquare() {
        for(int i = 1; i<=4; i++) {
            for (int j=1; j<=4; j++) {
                System.out.print("|"+ i*j +"\t");
            }
            System.out.println("|");
        }
    }

    /**
     * compare effect between foreach, for, do-while, iterator and foreach lambda loop
     */
    public static void loopEffect() {

        System.out.println("<<<<Effect compare " + MAX_NUM + " times " + " with " + MAX_TIMES + " loop>>>>");
        if (list.size() == 0) init();
        // for loop
        long origin = new Date().getTime();
        int times = 0;
        String temp = "";
        do{
            for (int i = 1; i < MAX_NUM; i++) {
                temp = list.get(i);
            }
        }while (++times < MAX_TIMES);

        long for_now = new Date().getTime();
        System.out.println("for loop average cose : " + (for_now - origin) + " ms ");

        // foreach loop
        origin = new Date().getTime();
        times = 0;
        do {
            for (String str : list) {
                temp = str;
            }
        }while (++times < MAX_TIMES);
        long foreach_now = new Date().getTime();
        System.out.println("foreach loop average cose : " + (foreach_now - origin) + " ms ");

        // iterator loop
        origin = new Date().getTime();
        times = 0;
        do {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                temp = iterator.next();
            };
        } while (++times < MAX_TIMES);
        long iterator_loop = new Date().getTime();
        System.out.println("iterator loop average cose : " + (iterator_loop - origin) + " ms ");

        // foreach lambda loop
        origin = new Date().getTime();
        times = 0;
        do {
            list.forEach(x -> x = x);
        } while (++times < MAX_TIMES);
        long foreach_lambda_loop = new Date().getTime();
        System.out.println("foreach lambda loop average cose : " + (foreach_lambda_loop - origin) + " ms ");
    }

    /**
     * init the environment
     */
    public static void init() {
        for (int i = 0; i < MAX_NUM; i++) {
            list.add("xx");
        }
        System.out.println("Init Value OK");
    }
}
