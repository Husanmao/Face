package com.huawei.colin.util.Converter.impl;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @Author: hudongfeng
 * @Description:使用静态内部类提供全局唯一的ObjectManager对象
 * @Date: 19/07/2018
 */
public final class JacksonMapper {

    private JacksonMapper() {
    }

    static class ObjectMapperGetter {
        public static final ObjectMapper singleInstance= new ObjectMapper();
    }

    public static ObjectMapper getInstance() {
        return ObjectMapperGetter.singleInstance;
    }
}
