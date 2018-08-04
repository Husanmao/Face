package com.huawei.colin.Problems;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 17/07/2018
 */
public final class MyJsonConverter implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    transient  String name;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Object a = null;
        int b = (int)a;
        System.out.println(b);
    }
}
