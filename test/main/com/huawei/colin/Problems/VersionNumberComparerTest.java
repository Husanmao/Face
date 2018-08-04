package com.huawei.colin.Problems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 10/07/2018
 */
public class VersionNumberComparerTest {
    @Test
    public void isIllegal() throws Exception {
        assertTrue(VersionNumberComparer.isIllegal("234ab"));
    }

    @Test
    public void compareVersionNumber() throws Exception {
        assertEquals(1, VersionNumberComparer.compareVersionNumber("123.234", "23.2345324"));
    }

}