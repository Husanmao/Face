package com.huawei.colin.util.Converter.impl;

import com.huawei.colin.util.Converter.JsonConverter;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public class JsonConverterFactory {

    public enum ConverterType {
        GSON,
        JSON_LIB,
        JACKSON
    }

    public static JsonConverter getJsonConverter(ConverterType converterType) {
        switch(converterType) {
            case GSON:
                return new GsonConverter();
            case JACKSON:
                return new JacksonConverter();
            case JSON_LIB:
                return new JsonlibConverter();
            default:
                break;
        }
        return null;
    }

    public static Object getJsonConverter2(Class<?extends JsonConverter> clazz) {
        Object res = null;
        try {
            res = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }
        return res;
    }
}
