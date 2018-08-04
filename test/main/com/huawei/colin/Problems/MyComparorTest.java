package com.huawei.colin.Problems;

import com.huawei.colin.util.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 16/07/2018
 */
public class MyComparorTest {
    private static List<Student> mStudent = new ArrayList<>();
    private static int MAX_COMPARE_TIMES;

    public void init() {

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

        /**
         * init max compare times
         */
        MAX_COMPARE_TIMES = (int)Math.pow(10, 7);
    }

    @Before
    public void Setup() throws Exception {
        init();
    }

    @Test
    public void sortStudent() throws Exception {
        MyComparor.sortStudent(mStudent);
        List<Student> m1 = mStudent;

        init();
        MyComparor.sortStudent2(mStudent);
        List<Student> m2 = mStudent;

        for (int i = 0; i < m2.size(); i++) {
            assertEquals(m1.get(i).getAge(), m2.get(i).getAge());
            assertEquals(m1.get(i).getName(), m2.get(i).getName());
        }
    }

    @Test
    public void performance() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_COMPARE_TIMES; i++) {
            MyComparor.sortStudent(mStudent);
        }
        System.out.println(MAX_COMPARE_TIMES / (System.currentTimeMillis() - start));
    }

}