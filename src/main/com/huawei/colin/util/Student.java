package com.huawei.colin.util;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 16/07/2018
 */
public class Student {

    private int age;
    private String name;

    public Student(){}

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
