package com.huawei.colin.util;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;

/**
 * @Author: hudongfeng
 * @Description:Logger Util
 * @Date: 2017/11/23
 */
public class LoggerUtil {

    @Contract(pure = true)
    public static void error(Logger logger, String msg) {
        logger.error(msg);
    }

    @Contract(pure = true)
    public static void debug(Logger logger, String msg) {
        if (logger.isDebugEnabled()) logger.debug(msg);
    }

    @Contract(pure = true)
    public static void info(Logger logger, String msg) {
        if (logger.isInfoEnabled()) logger.info(msg);
    }

    @Contract(pure = true)
    public static void warn(Logger logger, String msg) {
        logger.warn(msg);
    }
}
