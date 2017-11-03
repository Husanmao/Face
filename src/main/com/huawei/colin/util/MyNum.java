package com.huawei.colin.util;

import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 主要提供一些数字运算的基础方法
 */
public final class MyNum {

    private static SecureRandom secureRandom;
    private static final Logger logger = Logger.getLogger(MyNum.class);

    /**
     * Get a secure random number
     * @return Secure rnndom number
     */
    public static int getRandom() {
        try {
            secureRandom  = SecureRandom.getInstanceStrong();
            return secureRandom.nextInt();
        } catch (NoSuchAlgorithmException e) {
            logger.error("get secure random number failed, using random number instead.");
            return new Random().nextInt();
        }
    }
}
