package com.huawei.colin.util.Converter.impl;

import com.huawei.colin.util.Converter.JsonConverter;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.lang.reflect.Field;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public class JsonlibConverter implements JsonConverter {

    @Override
    public String toJson(Object bean) throws ParseJsonException {
        return JSONObject.fromObject(bean).toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromJson(String jsonString, Class<T> beanClass) throws ParseJsonException{
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Object res;
        try {
            res = JSONObject.toBean(jsonObject, beanClass);
        } catch (JSONException e) {
            throw new ParseJsonException("parse json error");
        }
        return (T)res;
    }

    /**
     *
     * @param bean
     * @param _nory_changes
     * @param nory
     * @return
     */
    public static String beanToJson2(Object bean, String[] _nory_changes, boolean nory) {
        JSONObject json;
        if(nory) {
            Field[] fields = bean.getClass().getDeclaredFields();
            String str = "";
            for(Field field : fields) {
                str += (":" + field.getName());
            }

            fields = bean.getClass().getSuperclass().getDeclaredFields();
            for(Field field : fields) {
                str += (":" + field.getName());
            }
            str += ":";
            for(String s : _nory_changes) {
                str = str.replace(":" + s + ":", ":");
            }
            json  = JSONObject.fromObject(bean, configJson(str.split(":")));
        }else {
            json = JSONObject.fromObject(bean, configJson(_nory_changes));
        }

        return json.toString();
    }

    private static JsonConfig configJson(String[] excludes) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(false);
        return jsonConfig;
    }

}
