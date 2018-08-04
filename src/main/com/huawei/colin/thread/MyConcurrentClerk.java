package com.huawei.colin.thread;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 23/06/2018
 */
public class MyConcurrentClerk {

    public static void main(String[] args) {

    }
}

class Clerk extends Thread {

    private static int num_of_goods = 20;

    public synchronized void add() {

    }
}

class producer extends Thread {

    private Clerk mClerk;

    producer(Clerk clerk) {
        this.mClerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            mClerk.add();
        }
    }
}

class consumer {

}