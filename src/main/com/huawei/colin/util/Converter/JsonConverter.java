package com.huawei.colin.util.Converter;

import com.huawei.colin.util.Converter.impl.ParseJsonException;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public interface JsonConverter {

    String toJson(Object bean) throws ParseJsonException;
    <T> T fromJson(String jsonString, Class<T> beanClass) throws ParseJsonException;
}
