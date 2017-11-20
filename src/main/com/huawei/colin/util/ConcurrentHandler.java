package com.huawei.colin.util;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/19
 */
public final class ConcurrentHandler {
    //private static ConcurrentHandler ourInstance = new ConcurrentHandler();

    private static int count = 0;


    public static ConcurrentHandler getInstance() {
        if (count < 3) {
            count++;
            return new ConcurrentHandler();
        } else {
            return null;
        }
    }

    private ConcurrentHandler() {
    }
}
