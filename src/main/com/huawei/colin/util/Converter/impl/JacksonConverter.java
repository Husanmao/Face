package com.huawei.colin.util.Converter.impl;

import com.huawei.colin.util.Converter.JsonConverter;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public class JacksonConverter implements JsonConverter {

    @Override
    public String toJson(Object bean) throws ParseJsonException {
        ObjectMapper mapper = JacksonMapper.getInstance();
        StringWriter sw = new StringWriter();
        try {
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, bean);
            gen.close();
        } catch (IOException e) {
            throw new ParseJsonException("write to json error");
        }
        return sw.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromJson(String jsonString, Class<T> beanClass) throws ParseJsonException {
        ObjectMapper mapper = JacksonMapper.getInstance();
        Object res;
        try {
            res = mapper.readValue(jsonString, beanClass);
        } catch (IOException e) {
            throw new ParseJsonException("parse json errro");
        }
        return (T)res;
    }
}
