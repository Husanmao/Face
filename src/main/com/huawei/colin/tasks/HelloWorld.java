package com.huawei.colin.tasks;

import com.huawei.colin.tasks.inf.Task;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2018/1/10
 */
public class HelloWorld extends SparkTask implements Task{

    public static final Pattern SPACE = Pattern.compile("[^a-zA-Z\\d]+");

    HelloWorld(String AppName, String Master, String DataSource) {
        super(AppName, Master, DataSource);
    }

    public int process() {
        return 0;
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld("Face", "local", "hdfs://localhost:8020/");
        SparkConf conf = new SparkConf().setAppName(hw.AppName).setMaster(hw.Master).setJars(new String[]{"/Users/colin/IdeaProjects/Face/out/artifacts/Face_jar/Face.jar"});
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lines = jsc.textFile(hw.DataSource);
        long begin = System.currentTimeMillis();

        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(SPACE.split(s)).iterator();
            }
        });

        JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s.toLowerCase(), 1);
            }
        });

        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1 + ":" + tuple._2);
        }
        long now = System.currentTimeMillis();
        System.out.println("Cost time is " + (now - begin) + " ms ");
        jsc.stop();
    }
}
