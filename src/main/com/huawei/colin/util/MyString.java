package com.huawei.colin.util;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;

import java.util.Date;

/**
 * @Author: hudongfeng
 * @Description: My String Utils
 * @Date: 2017/11/19
 */
public final class MyString {

    // Max string length we use
    private static final int MAX_LENGTH = 10000000;

    // How many loop we try
    private static final int TIMES = 10;

    /**
     * Compare the effect between StringBuilder、StringBuffer、String
     */
    public static void concatEffectCompare() {

        // string + effect
        long origin = new Date().getTime();
//        String str = "";
        int j = 0;
//        do {
//            for (int i = 0; i < MAX_LENGTH; i++) {
//                str += "x";
//            }
//        } while (++j < TIMES);
//
//        long plus_between = new Date().getTime() - origin;
//        System.out.println("String Plus Average : " + plus_between / TIMES + " ms ");

        // string builder effect
        origin = new Date().getTime();
        j = 0;
        StringBuilder sb = new StringBuilder();
        do {
            for (int i = 0; i < MAX_LENGTH; i++) {
                sb.append("x");
            }
        } while (++j < TIMES);
        long builder_between = new Date().getTime() - origin;
        System.out.println("String Builder Average : " + builder_between / TIMES + " ms ");

        // string buffer effect
        origin = new Date().getTime();
        j = 0;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            for (int i = 0; i < MAX_LENGTH; i++) {
                stringBuffer.append("x");
            }
        } while (++j < TIMES);
        long buffer_between = new Date().getTime() - origin;
        System.out.println("String Buffer Average : " + buffer_between / TIMES + " ms ");
    }

    /**
     * Check whether str is empty (null or length is 0)
     * @param str String
     * @return {@code true} if str is null or length equals 0, {@code false} otherwise
     */
    @NotNull
    @Contract(pure = true)
    public static boolean isEmpty(String str) {
        return str == null || str.length() < 1;
    }

    /**
     * Change string failed
     * @param b
     */
    public static void changeStr(String b) {    //b是a的一份拷贝，保存的地址是也是@918
        b = b + "husanmal"; //这里b + "husanmal"后系统会重新在heap中分配内存，
                            // 保存值，地址返回给b保存，此时的b保存的地址为@928
    }

    /**
     * Change stringbuffer succeed
     * @param s
     */
    public static void changeStr2(StringBuffer s) {
        s.append("husanmao");
    }

    public static void main(String[] args) {
        // 测试:Java对象传递为值传递，传递时只是传递一份包
        // 含指向对象实际值的引用的拷贝（也即指向heap中实际对象的存放地址）。
        //当函数中操作该拷贝对象时，如果是赋值操作，会修改引用（也即拷贝中的引用地址）
        //；如果是直接对拷贝对象做操作，例如append之类的操作，则实际操作的是保存的引用
        //地址指向的heap中的值

        String a = "hudongfeng";    //a保存的地址为@918
        changeStr(a);
        System.out.println(a);  //此时的a依旧是"hudongfeng"，地址是@918

        StringBuffer c = new StringBuffer("hudongfeng"); //地址为@434
        changeStr2(c); //地址为@434，不过内容，指向的值变了，长度变成26位了
        System.out.println(c);  //地址为@434，不变，但是指向的值变了
    }
}
