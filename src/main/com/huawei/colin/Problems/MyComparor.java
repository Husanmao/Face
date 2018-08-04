package com.huawei.colin.Problems;

import com.huawei.colin.util.Student;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.TransformingComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.jetbrains.annotations.Contract;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 16/07/2018
 */
public class MyComparor {


    public static void sortStudent(List<Student> mStudents) {
        Comparator mycmp = ComparableComparator.getInstance();
        mycmp = ComparatorUtils.nullHighComparator(mycmp);

        Transformer myTransformer = input -> input;

        Comparator comparator = new TransformingComparator(myTransformer);
        ComparatorChain multiSort = new ComparatorChain();
        multiSort.addComparator(new BeanComparator("age", comparator));
        multiSort.addComparator(new BeanComparator("name", mycmp), false);

        Collections.sort(mStudents, multiSort);
    }
    
    @Contract(pure = true)
    public static void sortStudent2(List<Student> mStudents) {
        Collections.sort(mStudents, (Student o1, Student o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o1.getAge() - o2.getAge();
            }
        });
//
//        Collections.sort(mStudents, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if (o1.getAge() == o2.getAge()) {
//                    return o1.getName().compareTo(o2.getName());
//                } else {
//                    return o1.getAge() - o2.getAge();
//                }
//            }
//        });
        
    }

    public static <T> int compare(T t1, T t2) {
        if(t1 instanceof Integer) {
            return ((Integer) t1).compareTo((Integer) t2);
        }
        return 0;
    }
}
