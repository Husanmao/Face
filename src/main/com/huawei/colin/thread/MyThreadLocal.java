package com.huawei.colin.thread;

/**
 * @Author: hudongfeng
 * @Description: 测试线程局部变量
 * @Date: 23/06/2018
 */
public class MyThreadLocal {
    private static final ThreadLocal a = new ThreadLocal();

    static class test extends Thread {
        @Override
        public void run() {
            String b = (String)a.get();
            if (null == b) {
                b = "hudongfeng";
                a.set(b);
            }
        }
    }
}
