package com.huawei.colin.util;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 29/07/2018
 */
public enum SortType {
    ASCEND("A"),
    DESCEND("D"),
    OPTIC("O");

    public static void myTest() {
        System.out.println(SortType.valueOf("ASCEND"));
    }

    private String type;

    SortType(String type) { this.type = type; }

    @Override
    public String toString() { return type; }
}
