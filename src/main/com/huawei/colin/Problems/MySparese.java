package com.huawei.colin.Problems;

import com.huawei.colin.util.MyNum;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MySparese {

    private static final Logger logger = Logger.getLogger(MySparese.class);

    private static final int MAX = 192433;

    private static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) {
        int[] nums = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            if (i == MAX / 2) map.put(32473, "hudongfengxxx");
            else map.put(MyNum.getRandom(),  "hudongfeng" + i);
        }

        logger.error(new Date().getTime());
        System.out.println(map.get(32473));
        logger.info(new Date().getTime());
    }
}
