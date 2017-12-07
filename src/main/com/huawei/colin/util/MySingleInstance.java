package com.huawei.colin.util;

import org.junit.runner.notification.RunListener;

/**
 * @Author: hudongfeng
 * @Description:线程安全的单例方法
 * @Date: 2017/12/7
 */
@RunListener.ThreadSafe
public final class MySingleInstance {

    private static class SingleInstance {
        private static MySingleInstance instance = new MySingleInstance();
    }

    /* Get single instance by inner-static class */
    public static MySingleInstance getInstance() {
        return SingleInstance.instance;
    }
}
