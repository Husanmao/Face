package com.huawei.colin.Problems;

import java.util.Scanner;

public class MyLoop {

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
}
