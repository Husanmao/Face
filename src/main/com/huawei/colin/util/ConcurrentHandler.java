package com.huawei.colin.util;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/19
 */
public class ConcurrentHandler {
    private static ConcurrentHandler ourInstance = new ConcurrentHandler();

    public static ConcurrentHandler getInstance() {
        return ourInstance;
    }

    private ConcurrentHandler() {
    }
}
