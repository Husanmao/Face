package com.huawei.colin.MyLock;

import org.jetbrains.annotations.Contract;

/**
 * @Author: hudongfeng
 * @Description: 测试
 * @Date: 25/06/2018
 */
public class MyStampedLock {

    private static MyStampedLock instance0 = new MyStampedLock();

    private static MyStampedLock instance;

    private MyStampedLock() {}

    private static class MyLock {
        private static MyStampedLock mInstance = new MyStampedLock();
    }

    public static void main(String[] args) {

    }

    public static MyStampedLock getInstance() {
        return MyLock.mInstance;
    }

    public static MyStampedLock getInstance2() {
        if (instance == null) {
            synchronized (MyStampedLock.class) {
                if (instance == null) {
                    instance = new MyStampedLock();
                }
            }
        }
        return instance;
    }

    public static MyStampedLock getInstance3() {
        return instance0;
    }


    @Contract(pure = true)
    public static void test() {
        synchronized (MyStampedLock.class) {
            System.out.println("hello world");
        }
    }
}
