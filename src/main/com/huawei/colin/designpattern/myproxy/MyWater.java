package com.huawei.colin.designpattern.myproxy;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 01/07/2018
 */
public class MyWater implements Water {
    @Override
    public void drink() {
        System.out.println("I'm drinking!");
    }
}
