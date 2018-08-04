package com.huawei.colin.util.Converter.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.colin.util.Converter.JsonConverter;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public class GsonConverter implements JsonConverter {

    @Override
    public String toJson(Object bean) throws ParseJsonException {
        return GsonMapper.getInstance().toJson(bean);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromJson(String jsonString, Class<T> beanClass) throws ParseJsonException {
        Gson gson = GsonMapper.getInstance();
        Object res;
        try {
            res = gson.fromJson(jsonString, beanClass);
        } catch (JsonSyntaxException jse) {
            throw new ParseJsonException("parse json error");
        }
        return (T)res;
    }
}
