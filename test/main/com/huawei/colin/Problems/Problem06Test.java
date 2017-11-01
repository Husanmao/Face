package com.huawei.colin.Problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem06Test {

    @Test
    public void convertTimeToWords() throws Exception {
        assertEquals("two to two", Problem06.convertTimeToWords("1:58"));
        assertEquals("two past two", Problem06.convertTimeToWords("2:02"));
        assertEquals("Quater past two", Problem06.convertTimeToWords("2:15"));
        assertEquals("seventeen past two", Problem06.convertTimeToWords("2:17"));
        assertEquals("half past two", Problem06.convertTimeToWords("2:30"));
        assertEquals("twenty-six to three", Problem06.convertTimeToWords("2:34"));
        assertEquals("Quater to three", Problem06.convertTimeToWords("2:45"));
        assertEquals("two o'clock", Problem06.convertTimeToWords("2:00"));
        assertEquals("twelve o'clock", Problem06.convertTimeToWords("12:00"));

    }

}