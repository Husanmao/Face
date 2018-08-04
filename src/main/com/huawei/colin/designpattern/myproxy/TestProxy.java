package com.huawei.colin.designpattern.myproxy;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 01/07/2018
 */
public class TestProxy {

    public static void main(String[] args) {
        Water w = new WaterProxy();
        w.drink();
    }
}
