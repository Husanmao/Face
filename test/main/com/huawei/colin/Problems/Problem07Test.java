package com.huawei.colin.Problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem07Test {
    @Test
    public void mapMorse() throws Exception {
        Problem07.mapMorse("hudongfeng");
    }

    @Test
    public void convertToPlain() throws Exception {
        assertEquals("I NEVER SAW A PURPLE COW", Problem07.convertToPlain(".. / -. . ...- . .-. / ... .- .-- / .- / .--. ..- .-. .--. .-.. . / -.-. --- .--"));

    }

    @Test
    public void converToMorse() throws Exception {

        assertEquals("../-.....-..-./....-.--/.-/.--...-.-..--..-.../-.-.---.--", Problem07.converToMorse("I NEVER SAW A PURPLE COW"));
    }

}