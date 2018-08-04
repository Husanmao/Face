package com.huawei.colin.tasks;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2018/1/10
 */
public class SparkTask {
    public String AppName;
    public String Master;
    public String DataSource;

    SparkTask() {}

    SparkTask(String AppName, String Master, String DataSource) {
        this.AppName = AppName;
        this.Master = Master;
        this.DataSource = DataSource;
    }
}
