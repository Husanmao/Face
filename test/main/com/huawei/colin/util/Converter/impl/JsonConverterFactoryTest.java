package com.huawei.colin.util.Converter.impl;

import com.google.gson.Gson;
import com.huawei.colin.util.Converter.JsonConverter;
import com.huawei.colin.util.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 19/07/2018
 */
public class JsonConverterFactoryTest {

    private static List<Student> mStudent = new ArrayList<>();
    private static final int MAX_TIMES = (int)Math.pow(10, 6);

    @Before
    public void SetUp() {
        /**
         * init students
         */
        mStudent = new ArrayList<>();

        Student user1 = new Student();
        user1.setAge(15);
        user1.setName( "A");
        mStudent.add(user1);

        Student user2 = new Student();
        user2.setAge(18);
        user2.setName( "B");
        mStudent.add(user2);

        Student user3 = new Student();
        user3.setAge(15);
        user3.setName("C");
        mStudent.add(user3);

        Student user4 = new Student();
        user4.setAge(25);
        user4.setName("34afjdslk");
        mStudent.add(user4);

        Student user5 = new Student();
        user5.setAge(2345);
        user5.setName("332342fsdaf");
        mStudent.add(user5);
    }

    @Test
    public void getJsonConverter() throws Exception {
        long JSON_LIB_OUTPUT = output(JsonConverterFactory.ConverterType.JSON_LIB);
        long GSON_OUTPUT = output(JsonConverterFactory.ConverterType.GSON);
        long JACKSON_OUTPUT = output(JsonConverterFactory.ConverterType.JACKSON);
        System.out.println("Performance compare:");
        System.out.println("    Json-lib:" + JSON_LIB_OUTPUT);
        System.out.println("    Gson:" + GSON_OUTPUT);
        System.out.println("    Jackson:" + JACKSON_OUTPUT);
    }

    private static long output(JsonConverterFactory.ConverterType converterType) throws ParseJsonException {
        JsonConverter jsonlib = JsonConverterFactory.getJsonConverter(converterType);
        Student user5 = new Student();
        user5.setName("332342fsdaf");
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_TIMES; i++) {
            user5.setAge((int)(Math.random() * 20));
            jsonlib.toJson(user5);
        }
        long end = System.currentTimeMillis();
        long costTime = end - start;
        return MAX_TIMES * 1000 / costTime;
    }

}