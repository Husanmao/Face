package com.huawei.colin.Problems;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;

/**
 * @Author: hudongfeng
 * @Description: 比较版本号
 * 例如:
 *  0.1 < 1.1 < 1.2 < 13.37
 * @Date: 10/07/2018
 */
public class VersionNumberComparer {

    public static void main(String[] args) {
        int res = VersionNumberComparer.compareVersionNumber("123.34", "127.4324");
        System.out.println(res);
    }

    public static boolean isIllegal(String version) {
        if (version.isEmpty()) return false;
        String filtered = version.replaceAll("[\\.\\d]+", "");
        return !filtered.isEmpty();
    }

    @Contract(pure = true)
    public static int compareVersionNumber(@NotNull String version1, @NotNull String version2) {
        if (isIllegal(version1) || isIllegal(version2))
            throw new IllegalArgumentException("version can't be null or empty, and must by formed by digits and dots");
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len1 = str1.length;
        int len2 = str2.length;
        int max_len = len1 > len2 ? len1 : len2;
        for (int i = 0; i < max_len; i++) {
            int v1 = i + 1 > len1 ? 0 : Integer.valueOf(str1[i]);
            int v2 = i + 1 > len2 ? 0 : Integer.valueOf(str2[i]);
            if (v1 != v2)
                return v1 > v2 ? 1 : -1;
            else
                continue;
        }
        return 0;
    }
}
