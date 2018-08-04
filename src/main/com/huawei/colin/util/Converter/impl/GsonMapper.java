package com.huawei.colin.util.Converter.impl;

import com.google.gson.Gson;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public final class GsonMapper {

    private GsonMapper(){}

    static class GsonGetter {
        public static final Gson gsonInstance = new Gson();
    }
    public static Gson getInstance() {
        return GsonGetter.gsonInstance;
    }
}
