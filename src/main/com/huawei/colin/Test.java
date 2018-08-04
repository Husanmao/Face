package com.huawei.colin;

import com.google.gson.Gson;
import com.huawei.colin.util.Converter.JsonConverter;
import com.huawei.colin.util.Converter.impl.GsonConverter;
import com.huawei.colin.util.Converter.impl.GsonMapper;
import com.huawei.colin.util.Converter.impl.JsonConverterFactory;
import org.apache.log4j.Logger;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.joining;

/**
 * Test class
 */
public class Test {

    /** logger */
    private static final Logger LOGGER = Logger.getLogger(Test.class);

    /** Tag */
    public static final String TAG = Test.class.getSimpleName();

    private static final List<String> STOP_WORDS = Arrays.asList("AND", "OR", "BY", "OF");

    interface Convertor<F, T> {
        T convert(F from);
    }

    /**
     * @param input
     * @return
     */
    public static String acronym(final String input) {
        return Arrays
                .stream(input.toUpperCase().split("\\s"))
                .filter(word -> !STOP_WORDS.contains(word))
                .map(w -> String.valueOf(w.charAt(0)))
                .collect(joining(","));
    }

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;
//    private static volatile int i = 0;
    private static final AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        /* test java 8 lambda */
//        System.out.println(acronym("jklfjds kldfj K fd"));
//        Java8NewFeatures.myLambda("hudongfeng");
//        System.out.println(TAG);

        /* compare kinds of method concat efficient */
        //MyString.concatEffectCompare();

        /* java foreach loop */
//        Map<String, String> map = DP.initMap();
//        map.forEach((k, x)-> System.out.println(k + " -> " + x));

        /* compare kinds of method efficient */
//        MyLoop.loopEffect();
        /* compare Arrays.copyOfRange and System.arraycopy efficient */
//        MyArray.copyArrays();

        /* test if Array.copyOfRange copy value or copy ref */
//        String[] str1 = {"hu", "dongfeng", "feng"};
//        String[] str2 = Arrays.copyOfRange(str1, 0, 3);
//
//        LoggerUtil.debug(LOGGER, " " + "args = [" + args + "]");
//        ExecutorService pool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 100000; i++) {
//            pool.execute(() -> {
//                MySingleInstance temp = MySingleInstance.getInstance();
//                if (temp == null) {
//                    System.out.println("null");
//                }
//            });
//        }
//        System.out.println("end");
//        String a = "hudongfeng";
//        String b = "hudongfeng";
//        System.out.println(a == b);
//        System.out.println(a.hashCode() + " : " + b.hashCode());
//        Double[] assending = new Double[10];
//        for (int i = 0; i < assending.length; i++) {
//            assending[i] = (double)i;
//        }
//        printAddress("hudongfeng", "hudongfeng");
//        System.gc();
//        printAddress("hudongfeng", "hudongfeng");
//        a.intern();
//        Integer a = 129;
//        Integer b = 129;
//        System.out.println(a == b);
//        long start = System.currentTimeMillis();
//        Thread a = new Thread() {
//            @Override
//            public void run() {
//                for( int j = 0 ; j < 1000000000 ; j++ ) synchronized (LOGGER) {
//                    i.incrementAndGet();
////                    i++;
//                }
//            }
//        };
//        a.start();
//        Thread b = new Thread() {
//            @Override
//            public void run() {
//                for( int j = 0 ; j < 1000000000 ; j++ ) synchronized (LOGGER) {
//                    i.decrementAndGet();
////                    i--;
//                }
//            }
//        };
//        b.start();
//        a.join();
//        b.join();
//        long end = System.currentTimeMillis();
//        System.out.println("time cost " + (end - start));
//        String a = "hudongfeng";
//        String b  = "hudongfeng";
//        System.out.println(a==b);
//        String c = a;
//        System.out.println(c==a);
//        a = "husanmao";
//        System.out.println(c==a);
//        StringBuilder a = new StringBuilder(5000);
        JsonConverter gson = JsonConverterFactory.getJsonConverter(JsonConverterFactory.ConverterType.GSON);
        System.out.println(gson instanceof Object);
        if(gson instanceof GsonConverter) {
            System.out.println("gson");
        } else {
            System.out.println("not gson");
        }
        Boolean a = true;
        System.out.println(a);
    }

    public static int add(int i) {
        return i++;
    }
    public static void printAddress(String label, Object... objects) {
        System.out.print("label:0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());

        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.println(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i*4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", + " + Long.toHexString(i2 - last));
                    else
                        System.out.print(", - " + Long.toHexString(last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();

    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe)theUnsafe.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
