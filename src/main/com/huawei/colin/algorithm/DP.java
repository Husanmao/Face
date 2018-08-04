package com.huawei.colin.algorithm;

import com.huawei.colin.compare.MyString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DP {

    // Map int num to char (eg: 1 -> a)
    private static Map<String, String> map = new ConcurrentHashMap<String, String>();

	/** Dynamic Programming Examples
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Question 1 : 最长公共子序列(Longest Common Subsequence(LCS))
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int getLongestCommonSub(String str1, String str2) {
        return 0;
    }

    /**
     * 给定一串字符串1234129，映射到字符数组（其中1->a, 2->b, ... , 26->z）
     * 判断数字串能否映射成一段字符串
     * @param str 待映射的数字串
     * @return {@code true} if we can, {@code false} otherwise
     */
    public static boolean canTranscode(String str) {
        // string can't be empty and can only contains 0~9
        if (MyString.isEmpty(str))
            throw new IllegalArgumentException("Arguments can't be null or length equals 0");

        char[] chs = str.toCharArray();
        for (char ch : chs) {
            if (ch < '0' || ch > '9')
                throw new IllegalArgumentException("invalid string, can only be 0~9");
        }

        return canTranscodeImpl(str, null);
    }

    static String op = "";

    /**
     * The implements for check if we can transcode
     * @param str Param str
     * @param output Param output
     * @return {@code true} if we can transcode, {@code false} otherwise
     */
    public static boolean canTranscodeImpl(String str, String output) {
        if (MyString.isEmpty(str) || str.length() == 1) {
            op = map.get(str);
            return true;
        }
        if (str.length() == 2) {
            if (Integer.parseInt(str) <= 26) {
                op = map.get(str);
                return true;
            }
            return false;
        }

        String temp = str.substring(str.length() - 2, str.length());
        int last_two_value = Integer.parseInt(temp);
        if (last_two_value <= 26) {
            op = map.get(temp);
            return canTranscodeImpl(str.substring(0, str.length() - 1), op + output)
                    || canTranscodeImpl(str.substring(0, str.length() - 2), op + output);
        } else {
            op = map.get(str.substring(str.length() - 1, str.length()));
            return canTranscodeImpl(str.substring(0, str.length() - 1), op + output);
        }
    }

    /**
     * init map with pairs like "1" -> "a"
     * @return The inited map
     */
    public static Map<String, String> initMap() {
        for (int i = 0; i < 26; i++) {
            map.put((i + 1 + ""), (char)('a' + i) + "");
        }
        return map;
    }
}
