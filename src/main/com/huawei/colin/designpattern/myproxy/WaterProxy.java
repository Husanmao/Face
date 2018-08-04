package com.huawei.colin.designpattern.myproxy;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 01/07/2018
 */
public class WaterProxy implements Water {
    private static Water w = new MyWater();

    @Override
    public void drink() {
        w.drink();
    }
}
